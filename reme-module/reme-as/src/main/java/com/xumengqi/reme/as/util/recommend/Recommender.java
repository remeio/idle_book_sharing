package com.xumengqi.reme.as.util.recommend;

import com.xumengqi.reme.as.logic.book.impl.BookLogicImpl;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xumengqi
 * @date 2021/4/3 16:28
 */
public class Recommender {
    private static final Logger log = Logger.getLogger(Recommender.class);

    public static Set<Long> recommend(Long userId, List<BookSample> bookSampleList, int k) {
        Set<Sample> sampleSet = getEntrySet(bookSampleList);
        return recommend(userId, sampleSet, k);

    }

    public static Set<Long> recommend(Long userId, Set<Sample> sampleSet, int k) {
        // 查找
        Sample sample = sampleSet.stream().filter(e -> e.getId().equals(userId)).findFirst().orElse(null);
        if (sample == null) {
            throw new RecommendException("not found user id");
        }
        // 从原集合移除
        sampleSet.remove(sample);
        // 推荐
        return recommend(sample, sampleSet, k);
    }

    public static Set<Sample> getEntrySet(List<BookSample> bookSamples) {
        // 结果集
        Set<Sample> sampleSet = new HashSet<>();
        long size = bookSamples.stream().map(BookSample::getBookCatalogId).max(Long::compare).orElse(0L);
        // 对每个 user 处理
        Set<Long> userIdSet = bookSamples.stream().map(BookSample::getUserId).collect(Collectors.toSet());
        userIdSet.forEach(userId -> {
            // 筛选相应的数据
            List<BookSample> userBookSample = bookSamples.stream().filter(bookSample -> bookSample.getUserId().equals(userId)).collect(Collectors.toList());
            // 将数据封装为 map
            Map<Long, Double> catalogMap = new HashMap<>();
            userBookSample.forEach(data -> {
                catalogMap.put(data.getBookCatalogId() - 1, (double) data.getCount());
            });
            // 封装
            sampleSet.add(createEntry(userId, getData(catalogMap, (int) size)));
        });
        return sampleSet;
    }

    public static List<Double> getData(Map<Long, Double> map, int size) {
        double[] doubles = new double[size];
        for (int i = 0; i < doubles.length; i++) {
            Double value = map.get((long) i);
            doubles[i] = value == null ? 0 : value;
        }
        List<Double> result = new ArrayList<>(size);
        Arrays.stream(doubles).forEach(result::add);
        return result;
    }

    public static Sample createEntry(Long id, List<Double> data) {
        Sample sample = new Sample();
        sample.setId(id);
        sample.setData(data);
        return sample;
    }

    public static void checkArgs(Sample sample, Set<Sample> sampleSet, int k) {
        if (k <= 0) {
            throw new RecommendException("k is less than 0, or equals 0");
        }
        if (sample == null || sampleSet == null || sampleSet.size() == 0) {
            throw new RecommendException("invalid args");
        }
        if (sample.getData() == null) {
            throw new RecommendException("invalid args: sample data is null");
        }
        int size = sample.getData().size();
        sampleSet.forEach(e -> {
            if (e.getData() == null) {
                throw new RecommendException("invalid args: entry data is null");
            }
            if (e.getData().size() != size) {
                throw new RecommendException("size not same");
            }
        });
    }


    /**
     * KNN 推荐
     *
     * @param sample    样本
     * @param sampleSet 数据
     * @param k         邻居数
     * @return 样本中 ID
     */
    public static Set<Long> recommend(Sample sample, Set<Sample> sampleSet, int k) {
        log.info("推荐样本为：" + sample);
        log.info("推荐数据为：" + sampleSet);
        log.info("邻居个数为：" + k);
        checkArgs(sample, sampleSet, k);
        Map<Long, Double> simDistanceMap = new HashMap<>(sampleSet.size());
        // 计算欧式距离
        sampleSet.forEach(e -> {
            double sim = SimDistance.getSimDistance(listToArray(e.getData()), listToArray(sample.getData()));
            simDistanceMap.put(e.getId(), sim);
        });
        // 按照欧式距离升序排列
        Set<Map.Entry<Long, Double>> simDistanceEntrySet = simDistanceMap.entrySet();
        simDistanceEntrySet = simDistanceEntrySet.stream().sorted(Comparator.comparingDouble(Map.Entry::getValue)).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Map.Entry<Long, Double>> neighbors = new HashSet<>();
        log.info("allData: " + neighbors);
        // 取前 k 个邻居
        if (simDistanceEntrySet.size() <= k) {
            neighbors = simDistanceEntrySet;
        } else {
            int i = 0;
            for (Map.Entry<Long, Double> longDoubleEntry : simDistanceEntrySet) {
                neighbors.add(longDoubleEntry);
                i++;
                if (i == k) {
                    break;
                }
            }
        }
        Set<Long> neighborIdList = neighbors.stream().map(Map.Entry::getKey).collect(Collectors.toSet());
        Set<Double> distanceList = neighbors.stream().map(Map.Entry::getValue).collect(Collectors.toSet());
        Iterator<Long> neighborIdIterator = neighborIdList.iterator();
        Iterator<Double> distanceIterator = distanceList.iterator();
        while (neighborIdIterator.hasNext()) {
            log.info("neighborId: " + neighborIdIterator.next() + ", distance: " + distanceIterator.next());
        }
        return neighborIdList;
    }

    public static double[] listToArray(List<Double> doubleList) {
        double[] doubles = new double[doubleList.size()];
        for (int i = 0; i < doubleList.size(); i++) {
            doubles[i] = doubleList.get(i);
        }
        return doubles;
    }
}
