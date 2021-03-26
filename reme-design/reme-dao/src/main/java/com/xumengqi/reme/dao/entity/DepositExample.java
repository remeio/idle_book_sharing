package com.xumengqi.reme.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepositExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepositExample() {
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

        public Criteria andDepositIdIsNull() {
            addCriterion("deposit_id is null");
            return (Criteria) this;
        }

        public Criteria andDepositIdIsNotNull() {
            addCriterion("deposit_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepositIdEqualTo(Long value) {
            addCriterion("deposit_id =", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdNotEqualTo(Long value) {
            addCriterion("deposit_id <>", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdGreaterThan(Long value) {
            addCriterion("deposit_id >", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdGreaterThanOrEqualTo(Long value) {
            addCriterion("deposit_id >=", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdLessThan(Long value) {
            addCriterion("deposit_id <", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdLessThanOrEqualTo(Long value) {
            addCriterion("deposit_id <=", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdIn(List<Long> values) {
            addCriterion("deposit_id in", values, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdNotIn(List<Long> values) {
            addCriterion("deposit_id not in", values, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdBetween(Long value1, Long value2) {
            addCriterion("deposit_id between", value1, value2, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdNotBetween(Long value1, Long value2) {
            addCriterion("deposit_id not between", value1, value2, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoIsNull() {
            addCriterion("deposit_order_no is null");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoIsNotNull() {
            addCriterion("deposit_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoEqualTo(String value) {
            addCriterion("deposit_order_no =", value, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoNotEqualTo(String value) {
            addCriterion("deposit_order_no <>", value, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoGreaterThan(String value) {
            addCriterion("deposit_order_no >", value, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("deposit_order_no >=", value, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoLessThan(String value) {
            addCriterion("deposit_order_no <", value, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoLessThanOrEqualTo(String value) {
            addCriterion("deposit_order_no <=", value, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoLike(String value) {
            addCriterion("deposit_order_no like", value, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoNotLike(String value) {
            addCriterion("deposit_order_no not like", value, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoIn(List<String> values) {
            addCriterion("deposit_order_no in", values, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoNotIn(List<String> values) {
            addCriterion("deposit_order_no not in", values, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoBetween(String value1, String value2) {
            addCriterion("deposit_order_no between", value1, value2, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositOrderNoNotBetween(String value1, String value2) {
            addCriterion("deposit_order_no not between", value1, value2, "depositOrderNo");
            return (Criteria) this;
        }

        public Criteria andDepositAmountIsNull() {
            addCriterion("deposit_amount is null");
            return (Criteria) this;
        }

        public Criteria andDepositAmountIsNotNull() {
            addCriterion("deposit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDepositAmountEqualTo(Long value) {
            addCriterion("deposit_amount =", value, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountNotEqualTo(Long value) {
            addCriterion("deposit_amount <>", value, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountGreaterThan(Long value) {
            addCriterion("deposit_amount >", value, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("deposit_amount >=", value, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountLessThan(Long value) {
            addCriterion("deposit_amount <", value, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountLessThanOrEqualTo(Long value) {
            addCriterion("deposit_amount <=", value, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountIn(List<Long> values) {
            addCriterion("deposit_amount in", values, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountNotIn(List<Long> values) {
            addCriterion("deposit_amount not in", values, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountBetween(Long value1, Long value2) {
            addCriterion("deposit_amount between", value1, value2, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositAmountNotBetween(Long value1, Long value2) {
            addCriterion("deposit_amount not between", value1, value2, "depositAmount");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeIsNull() {
            addCriterion("deposit_operate_type is null");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeIsNotNull() {
            addCriterion("deposit_operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeEqualTo(Integer value) {
            addCriterion("deposit_operate_type =", value, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeNotEqualTo(Integer value) {
            addCriterion("deposit_operate_type <>", value, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeGreaterThan(Integer value) {
            addCriterion("deposit_operate_type >", value, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deposit_operate_type >=", value, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeLessThan(Integer value) {
            addCriterion("deposit_operate_type <", value, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("deposit_operate_type <=", value, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeIn(List<Integer> values) {
            addCriterion("deposit_operate_type in", values, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeNotIn(List<Integer> values) {
            addCriterion("deposit_operate_type not in", values, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeBetween(Integer value1, Integer value2) {
            addCriterion("deposit_operate_type between", value1, value2, "depositOperateType");
            return (Criteria) this;
        }

        public Criteria andDepositOperateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("deposit_operate_type not between", value1, value2, "depositOperateType");
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

        public Criteria andInnerOrderNoIsNull() {
            addCriterion("inner_order_no is null");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoIsNotNull() {
            addCriterion("inner_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoEqualTo(String value) {
            addCriterion("inner_order_no =", value, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoNotEqualTo(String value) {
            addCriterion("inner_order_no <>", value, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoGreaterThan(String value) {
            addCriterion("inner_order_no >", value, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("inner_order_no >=", value, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoLessThan(String value) {
            addCriterion("inner_order_no <", value, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoLessThanOrEqualTo(String value) {
            addCriterion("inner_order_no <=", value, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoLike(String value) {
            addCriterion("inner_order_no like", value, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoNotLike(String value) {
            addCriterion("inner_order_no not like", value, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoIn(List<String> values) {
            addCriterion("inner_order_no in", values, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoNotIn(List<String> values) {
            addCriterion("inner_order_no not in", values, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoBetween(String value1, String value2) {
            addCriterion("inner_order_no between", value1, value2, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andInnerOrderNoNotBetween(String value1, String value2) {
            addCriterion("inner_order_no not between", value1, value2, "innerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoIsNull() {
            addCriterion("outer_order_no is null");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoIsNotNull() {
            addCriterion("outer_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoEqualTo(String value) {
            addCriterion("outer_order_no =", value, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoNotEqualTo(String value) {
            addCriterion("outer_order_no <>", value, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoGreaterThan(String value) {
            addCriterion("outer_order_no >", value, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("outer_order_no >=", value, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoLessThan(String value) {
            addCriterion("outer_order_no <", value, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoLessThanOrEqualTo(String value) {
            addCriterion("outer_order_no <=", value, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoLike(String value) {
            addCriterion("outer_order_no like", value, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoNotLike(String value) {
            addCriterion("outer_order_no not like", value, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoIn(List<String> values) {
            addCriterion("outer_order_no in", values, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoNotIn(List<String> values) {
            addCriterion("outer_order_no not in", values, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoBetween(String value1, String value2) {
            addCriterion("outer_order_no between", value1, value2, "outerOrderNo");
            return (Criteria) this;
        }

        public Criteria andOuterOrderNoNotBetween(String value1, String value2) {
            addCriterion("outer_order_no not between", value1, value2, "outerOrderNo");
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