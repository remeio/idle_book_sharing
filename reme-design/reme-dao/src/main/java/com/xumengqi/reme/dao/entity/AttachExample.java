package com.xumengqi.reme.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttachExample() {
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

        public Criteria andAttachIdIsNull() {
            addCriterion("attach_id is null");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNotNull() {
            addCriterion("attach_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttachIdEqualTo(Long value) {
            addCriterion("attach_id =", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotEqualTo(Long value) {
            addCriterion("attach_id <>", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThan(Long value) {
            addCriterion("attach_id >", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attach_id >=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThan(Long value) {
            addCriterion("attach_id <", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThanOrEqualTo(Long value) {
            addCriterion("attach_id <=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdIn(List<Long> values) {
            addCriterion("attach_id in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotIn(List<Long> values) {
            addCriterion("attach_id not in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdBetween(Long value1, Long value2) {
            addCriterion("attach_id between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotBetween(Long value1, Long value2) {
            addCriterion("attach_id not between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathIsNull() {
            addCriterion("attach_full_path is null");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathIsNotNull() {
            addCriterion("attach_full_path is not null");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathEqualTo(String value) {
            addCriterion("attach_full_path =", value, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathNotEqualTo(String value) {
            addCriterion("attach_full_path <>", value, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathGreaterThan(String value) {
            addCriterion("attach_full_path >", value, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathGreaterThanOrEqualTo(String value) {
            addCriterion("attach_full_path >=", value, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathLessThan(String value) {
            addCriterion("attach_full_path <", value, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathLessThanOrEqualTo(String value) {
            addCriterion("attach_full_path <=", value, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathLike(String value) {
            addCriterion("attach_full_path like", value, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathNotLike(String value) {
            addCriterion("attach_full_path not like", value, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathIn(List<String> values) {
            addCriterion("attach_full_path in", values, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathNotIn(List<String> values) {
            addCriterion("attach_full_path not in", values, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathBetween(String value1, String value2) {
            addCriterion("attach_full_path between", value1, value2, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachFullPathNotBetween(String value1, String value2) {
            addCriterion("attach_full_path not between", value1, value2, "attachFullPath");
            return (Criteria) this;
        }

        public Criteria andAttachNameIsNull() {
            addCriterion("attach_name is null");
            return (Criteria) this;
        }

        public Criteria andAttachNameIsNotNull() {
            addCriterion("attach_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttachNameEqualTo(String value) {
            addCriterion("attach_name =", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameNotEqualTo(String value) {
            addCriterion("attach_name <>", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameGreaterThan(String value) {
            addCriterion("attach_name >", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameGreaterThanOrEqualTo(String value) {
            addCriterion("attach_name >=", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameLessThan(String value) {
            addCriterion("attach_name <", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameLessThanOrEqualTo(String value) {
            addCriterion("attach_name <=", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameLike(String value) {
            addCriterion("attach_name like", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameNotLike(String value) {
            addCriterion("attach_name not like", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameIn(List<String> values) {
            addCriterion("attach_name in", values, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameNotIn(List<String> values) {
            addCriterion("attach_name not in", values, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameBetween(String value1, String value2) {
            addCriterion("attach_name between", value1, value2, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameNotBetween(String value1, String value2) {
            addCriterion("attach_name not between", value1, value2, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachSizeIsNull() {
            addCriterion("attach_size is null");
            return (Criteria) this;
        }

        public Criteria andAttachSizeIsNotNull() {
            addCriterion("attach_size is not null");
            return (Criteria) this;
        }

        public Criteria andAttachSizeEqualTo(Long value) {
            addCriterion("attach_size =", value, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeNotEqualTo(Long value) {
            addCriterion("attach_size <>", value, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeGreaterThan(Long value) {
            addCriterion("attach_size >", value, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("attach_size >=", value, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeLessThan(Long value) {
            addCriterion("attach_size <", value, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeLessThanOrEqualTo(Long value) {
            addCriterion("attach_size <=", value, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeIn(List<Long> values) {
            addCriterion("attach_size in", values, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeNotIn(List<Long> values) {
            addCriterion("attach_size not in", values, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeBetween(Long value1, Long value2) {
            addCriterion("attach_size between", value1, value2, "attachSize");
            return (Criteria) this;
        }

        public Criteria andAttachSizeNotBetween(Long value1, Long value2) {
            addCriterion("attach_size not between", value1, value2, "attachSize");
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