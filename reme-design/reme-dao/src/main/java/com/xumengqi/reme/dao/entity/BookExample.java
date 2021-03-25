package com.xumengqi.reme.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIsNull() {
            addCriterion("book_isbn is null");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIsNotNull() {
            addCriterion("book_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andBookIsbnEqualTo(String value) {
            addCriterion("book_isbn =", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotEqualTo(String value) {
            addCriterion("book_isbn <>", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnGreaterThan(String value) {
            addCriterion("book_isbn >", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("book_isbn >=", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnLessThan(String value) {
            addCriterion("book_isbn <", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnLessThanOrEqualTo(String value) {
            addCriterion("book_isbn <=", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnLike(String value) {
            addCriterion("book_isbn like", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotLike(String value) {
            addCriterion("book_isbn not like", value, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnIn(List<String> values) {
            addCriterion("book_isbn in", values, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotIn(List<String> values) {
            addCriterion("book_isbn not in", values, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnBetween(String value1, String value2) {
            addCriterion("book_isbn between", value1, value2, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookIsbnNotBetween(String value1, String value2) {
            addCriterion("book_isbn not between", value1, value2, "bookIsbn");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionIsNull() {
            addCriterion("book_description is null");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionIsNotNull() {
            addCriterion("book_description is not null");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionEqualTo(String value) {
            addCriterion("book_description =", value, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionNotEqualTo(String value) {
            addCriterion("book_description <>", value, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionGreaterThan(String value) {
            addCriterion("book_description >", value, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("book_description >=", value, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionLessThan(String value) {
            addCriterion("book_description <", value, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionLessThanOrEqualTo(String value) {
            addCriterion("book_description <=", value, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionLike(String value) {
            addCriterion("book_description like", value, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionNotLike(String value) {
            addCriterion("book_description not like", value, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionIn(List<String> values) {
            addCriterion("book_description in", values, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionNotIn(List<String> values) {
            addCriterion("book_description not in", values, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionBetween(String value1, String value2) {
            addCriterion("book_description between", value1, value2, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookDescriptionNotBetween(String value1, String value2) {
            addCriterion("book_description not between", value1, value2, "bookDescription");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodIsNull() {
            addCriterion("book_max_period is null");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodIsNotNull() {
            addCriterion("book_max_period is not null");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodEqualTo(Integer value) {
            addCriterion("book_max_period =", value, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodNotEqualTo(Integer value) {
            addCriterion("book_max_period <>", value, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodGreaterThan(Integer value) {
            addCriterion("book_max_period >", value, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_max_period >=", value, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodLessThan(Integer value) {
            addCriterion("book_max_period <", value, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("book_max_period <=", value, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodIn(List<Integer> values) {
            addCriterion("book_max_period in", values, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodNotIn(List<Integer> values) {
            addCriterion("book_max_period not in", values, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodBetween(Integer value1, Integer value2) {
            addCriterion("book_max_period between", value1, value2, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookMaxPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("book_max_period not between", value1, value2, "bookMaxPeriod");
            return (Criteria) this;
        }

        public Criteria andBookDepositIsNull() {
            addCriterion("book_deposit is null");
            return (Criteria) this;
        }

        public Criteria andBookDepositIsNotNull() {
            addCriterion("book_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andBookDepositEqualTo(Integer value) {
            addCriterion("book_deposit =", value, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositNotEqualTo(Integer value) {
            addCriterion("book_deposit <>", value, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositGreaterThan(Integer value) {
            addCriterion("book_deposit >", value, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_deposit >=", value, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositLessThan(Integer value) {
            addCriterion("book_deposit <", value, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositLessThanOrEqualTo(Integer value) {
            addCriterion("book_deposit <=", value, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositIn(List<Integer> values) {
            addCriterion("book_deposit in", values, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositNotIn(List<Integer> values) {
            addCriterion("book_deposit not in", values, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositBetween(Integer value1, Integer value2) {
            addCriterion("book_deposit between", value1, value2, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookDepositNotBetween(Integer value1, Integer value2) {
            addCriterion("book_deposit not between", value1, value2, "bookDeposit");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlIsNull() {
            addCriterion("book_image_url is null");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlIsNotNull() {
            addCriterion("book_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlEqualTo(String value) {
            addCriterion("book_image_url =", value, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlNotEqualTo(String value) {
            addCriterion("book_image_url <>", value, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlGreaterThan(String value) {
            addCriterion("book_image_url >", value, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("book_image_url >=", value, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlLessThan(String value) {
            addCriterion("book_image_url <", value, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlLessThanOrEqualTo(String value) {
            addCriterion("book_image_url <=", value, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlLike(String value) {
            addCriterion("book_image_url like", value, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlNotLike(String value) {
            addCriterion("book_image_url not like", value, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlIn(List<String> values) {
            addCriterion("book_image_url in", values, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlNotIn(List<String> values) {
            addCriterion("book_image_url not in", values, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlBetween(String value1, String value2) {
            addCriterion("book_image_url between", value1, value2, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookImageUrlNotBetween(String value1, String value2) {
            addCriterion("book_image_url not between", value1, value2, "bookImageUrl");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdIsNull() {
            addCriterion("book_catalog_id is null");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdIsNotNull() {
            addCriterion("book_catalog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdEqualTo(Long value) {
            addCriterion("book_catalog_id =", value, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdNotEqualTo(Long value) {
            addCriterion("book_catalog_id <>", value, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdGreaterThan(Long value) {
            addCriterion("book_catalog_id >", value, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("book_catalog_id >=", value, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdLessThan(Long value) {
            addCriterion("book_catalog_id <", value, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdLessThanOrEqualTo(Long value) {
            addCriterion("book_catalog_id <=", value, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdIn(List<Long> values) {
            addCriterion("book_catalog_id in", values, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdNotIn(List<Long> values) {
            addCriterion("book_catalog_id not in", values, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdBetween(Long value1, Long value2) {
            addCriterion("book_catalog_id between", value1, value2, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andBookCatalogIdNotBetween(Long value1, Long value2) {
            addCriterion("book_catalog_id not between", value1, value2, "bookCatalogId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(Long value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(Long value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(Long value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(Long value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(Long value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<Long> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<Long> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(Long value1, Long value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(Long value1, Long value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}