//package com.xumengqi.reme.base;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.BiConsumer;
//import java.util.function.Consumer;
//import java.util.function.Supplier;
//
///**
// * @author xumengqi
// * @date 2021/1/29 12:40
// */
//public class GenericBuilder<T> {
//    private final Supplier<T> instantiator;
//    private final List<Consumer<T>> instantiatorModifiers = new ArrayList<>();
//    private final List<Consumer<T>> keyValueModifiers = new ArrayList<>();
//    private GenericBuilder(Supplier<T> instantiator) {
//        this .instantiator = instantiator;
//    }
//    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
//        return new GenericBuilder<T>(instantiator);
//    }
//    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
//        Consumer<T> c = instance -> consumer.accept(instance, value);
//        instantiatorModifiers.add(c);
//        return this ;
//    }
////    public <K, V> GenericBuilder<T> with(KeyValueConsumer<T, K, V> consumer, K key, V value) {
////        Consumer<T> c = instance -> consumer.accept(instance, key, value);
////        keyValueModifiers.add(c);
////        return this ;
////    }
//    public T build() {
//        T value = instantiator.get();
//        instantiatorModifiers.forEach(modifier -> modifier.accept(value));
//        keyValueModifiers.forEach(keyValueModifier -> keyValueModifier.accept(value));
//        instantiatorModifiers.clear();
//        keyValueModifiers.clear();
//        return value;
//    }
//
//    public static void main(String[] args) {
//        BaseResponse baseResponse = GenericBuilder
//                .of(BaseResponse::new)
//                .with(BaseResponse::setErrorNo, 1)
//                .with(BaseResponse::setErrorInfo, "a")
//                .build();
//        System.out.println(baseResponse);
//    }
//
//    interface TestFunc {
//        void test(String s);
//    }
//}