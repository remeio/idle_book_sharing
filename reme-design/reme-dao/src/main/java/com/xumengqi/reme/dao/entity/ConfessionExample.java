package com.xumengqi.reme.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConfessionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConfessionExample() {
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

        public Criteria andConfessionIdIsNull() {
            addCriterion("confession_id is null");
            return (Criteria) this;
        }

        public Criteria andConfessionIdIsNotNull() {
            addCriterion("confession_id is not null");
            return (Criteria) this;
        }

        public Criteria andConfessionIdEqualTo(Long value) {
            addCriterion("confession_id =", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdNotEqualTo(Long value) {
            addCriterion("confession_id <>", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdGreaterThan(Long value) {
            addCriterion("confession_id >", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("confession_id >=", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdLessThan(Long value) {
            addCriterion("confession_id <", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdLessThanOrEqualTo(Long value) {
            addCriterion("confession_id <=", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdIn(List<Long> values) {
            addCriterion("confession_id in", values, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdNotIn(List<Long> values) {
            addCriterion("confession_id not in", values, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdBetween(Long value1, Long value2) {
            addCriterion("confession_id between", value1, value2, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdNotBetween(Long value1, Long value2) {
            addCriterion("confession_id not between", value1, value2, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleIsNull() {
            addCriterion("confession_title is null");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleIsNotNull() {
            addCriterion("confession_title is not null");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleEqualTo(String value) {
            addCriterion("confession_title =", value, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleNotEqualTo(String value) {
            addCriterion("confession_title <>", value, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleGreaterThan(String value) {
            addCriterion("confession_title >", value, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("confession_title >=", value, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleLessThan(String value) {
            addCriterion("confession_title <", value, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleLessThanOrEqualTo(String value) {
            addCriterion("confession_title <=", value, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleLike(String value) {
            addCriterion("confession_title like", value, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleNotLike(String value) {
            addCriterion("confession_title not like", value, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleIn(List<String> values) {
            addCriterion("confession_title in", values, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleNotIn(List<String> values) {
            addCriterion("confession_title not in", values, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleBetween(String value1, String value2) {
            addCriterion("confession_title between", value1, value2, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionTitleNotBetween(String value1, String value2) {
            addCriterion("confession_title not between", value1, value2, "confessionTitle");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailIsNull() {
            addCriterion("confession_detail is null");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailIsNotNull() {
            addCriterion("confession_detail is not null");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailEqualTo(String value) {
            addCriterion("confession_detail =", value, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailNotEqualTo(String value) {
            addCriterion("confession_detail <>", value, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailGreaterThan(String value) {
            addCriterion("confession_detail >", value, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailGreaterThanOrEqualTo(String value) {
            addCriterion("confession_detail >=", value, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailLessThan(String value) {
            addCriterion("confession_detail <", value, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailLessThanOrEqualTo(String value) {
            addCriterion("confession_detail <=", value, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailLike(String value) {
            addCriterion("confession_detail like", value, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailNotLike(String value) {
            addCriterion("confession_detail not like", value, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailIn(List<String> values) {
            addCriterion("confession_detail in", values, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailNotIn(List<String> values) {
            addCriterion("confession_detail not in", values, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailBetween(String value1, String value2) {
            addCriterion("confession_detail between", value1, value2, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andConfessionDetailNotBetween(String value1, String value2) {
            addCriterion("confession_detail not between", value1, value2, "confessionDetail");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIsNull() {
            addCriterion("is_anonymous is null");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIsNotNull() {
            addCriterion("is_anonymous is not null");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousEqualTo(Integer value) {
            addCriterion("is_anonymous =", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotEqualTo(Integer value) {
            addCriterion("is_anonymous <>", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousGreaterThan(Integer value) {
            addCriterion("is_anonymous >", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_anonymous >=", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousLessThan(Integer value) {
            addCriterion("is_anonymous <", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousLessThanOrEqualTo(Integer value) {
            addCriterion("is_anonymous <=", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIn(List<Integer> values) {
            addCriterion("is_anonymous in", values, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotIn(List<Integer> values) {
            addCriterion("is_anonymous not in", values, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousBetween(Integer value1, Integer value2) {
            addCriterion("is_anonymous between", value1, value2, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotBetween(Integer value1, Integer value2) {
            addCriterion("is_anonymous not between", value1, value2, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdIsNull() {
            addCriterion("confession_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdIsNotNull() {
            addCriterion("confession_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdEqualTo(Long value) {
            addCriterion("confession_tag_id =", value, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdNotEqualTo(Long value) {
            addCriterion("confession_tag_id <>", value, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdGreaterThan(Long value) {
            addCriterion("confession_tag_id >", value, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdGreaterThanOrEqualTo(Long value) {
            addCriterion("confession_tag_id >=", value, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdLessThan(Long value) {
            addCriterion("confession_tag_id <", value, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdLessThanOrEqualTo(Long value) {
            addCriterion("confession_tag_id <=", value, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdIn(List<Long> values) {
            addCriterion("confession_tag_id in", values, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdNotIn(List<Long> values) {
            addCriterion("confession_tag_id not in", values, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdBetween(Long value1, Long value2) {
            addCriterion("confession_tag_id between", value1, value2, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionTagIdNotBetween(Long value1, Long value2) {
            addCriterion("confession_tag_id not between", value1, value2, "confessionTagId");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationIsNull() {
            addCriterion("confession_location is null");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationIsNotNull() {
            addCriterion("confession_location is not null");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationEqualTo(String value) {
            addCriterion("confession_location =", value, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationNotEqualTo(String value) {
            addCriterion("confession_location <>", value, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationGreaterThan(String value) {
            addCriterion("confession_location >", value, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationGreaterThanOrEqualTo(String value) {
            addCriterion("confession_location >=", value, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationLessThan(String value) {
            addCriterion("confession_location <", value, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationLessThanOrEqualTo(String value) {
            addCriterion("confession_location <=", value, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationLike(String value) {
            addCriterion("confession_location like", value, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationNotLike(String value) {
            addCriterion("confession_location not like", value, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationIn(List<String> values) {
            addCriterion("confession_location in", values, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationNotIn(List<String> values) {
            addCriterion("confession_location not in", values, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationBetween(String value1, String value2) {
            addCriterion("confession_location between", value1, value2, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andConfessionLocationNotBetween(String value1, String value2) {
            addCriterion("confession_location not between", value1, value2, "confessionLocation");
            return (Criteria) this;
        }

        public Criteria andIsSolvedIsNull() {
            addCriterion("is_solved is null");
            return (Criteria) this;
        }

        public Criteria andIsSolvedIsNotNull() {
            addCriterion("is_solved is not null");
            return (Criteria) this;
        }

        public Criteria andIsSolvedEqualTo(Integer value) {
            addCriterion("is_solved =", value, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedNotEqualTo(Integer value) {
            addCriterion("is_solved <>", value, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedGreaterThan(Integer value) {
            addCriterion("is_solved >", value, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_solved >=", value, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedLessThan(Integer value) {
            addCriterion("is_solved <", value, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedLessThanOrEqualTo(Integer value) {
            addCriterion("is_solved <=", value, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedIn(List<Integer> values) {
            addCriterion("is_solved in", values, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedNotIn(List<Integer> values) {
            addCriterion("is_solved not in", values, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedBetween(Integer value1, Integer value2) {
            addCriterion("is_solved between", value1, value2, "isSolved");
            return (Criteria) this;
        }

        public Criteria andIsSolvedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_solved not between", value1, value2, "isSolved");
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

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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