package com.xumengqi.reme.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserFullNameIsNull() {
            addCriterion("user_full_name is null");
            return (Criteria) this;
        }

        public Criteria andUserFullNameIsNotNull() {
            addCriterion("user_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserFullNameEqualTo(String value) {
            addCriterion("user_full_name =", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameNotEqualTo(String value) {
            addCriterion("user_full_name <>", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameGreaterThan(String value) {
            addCriterion("user_full_name >", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_full_name >=", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameLessThan(String value) {
            addCriterion("user_full_name <", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameLessThanOrEqualTo(String value) {
            addCriterion("user_full_name <=", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameLike(String value) {
            addCriterion("user_full_name like", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameNotLike(String value) {
            addCriterion("user_full_name not like", value, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameIn(List<String> values) {
            addCriterion("user_full_name in", values, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameNotIn(List<String> values) {
            addCriterion("user_full_name not in", values, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameBetween(String value1, String value2) {
            addCriterion("user_full_name between", value1, value2, "userFullName");
            return (Criteria) this;
        }

        public Criteria andUserFullNameNotBetween(String value1, String value2) {
            addCriterion("user_full_name not between", value1, value2, "userFullName");
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

        public Criteria andCanUseDepositIsNull() {
            addCriterion("can_use_deposit is null");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositIsNotNull() {
            addCriterion("can_use_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositEqualTo(Long value) {
            addCriterion("can_use_deposit =", value, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositNotEqualTo(Long value) {
            addCriterion("can_use_deposit <>", value, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositGreaterThan(Long value) {
            addCriterion("can_use_deposit >", value, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositGreaterThanOrEqualTo(Long value) {
            addCriterion("can_use_deposit >=", value, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositLessThan(Long value) {
            addCriterion("can_use_deposit <", value, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositLessThanOrEqualTo(Long value) {
            addCriterion("can_use_deposit <=", value, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositIn(List<Long> values) {
            addCriterion("can_use_deposit in", values, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositNotIn(List<Long> values) {
            addCriterion("can_use_deposit not in", values, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositBetween(Long value1, Long value2) {
            addCriterion("can_use_deposit between", value1, value2, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andCanUseDepositNotBetween(Long value1, Long value2) {
            addCriterion("can_use_deposit not between", value1, value2, "canUseDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositIsNull() {
            addCriterion("occupy_deposit is null");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositIsNotNull() {
            addCriterion("occupy_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositEqualTo(Long value) {
            addCriterion("occupy_deposit =", value, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositNotEqualTo(Long value) {
            addCriterion("occupy_deposit <>", value, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositGreaterThan(Long value) {
            addCriterion("occupy_deposit >", value, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositGreaterThanOrEqualTo(Long value) {
            addCriterion("occupy_deposit >=", value, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositLessThan(Long value) {
            addCriterion("occupy_deposit <", value, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositLessThanOrEqualTo(Long value) {
            addCriterion("occupy_deposit <=", value, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositIn(List<Long> values) {
            addCriterion("occupy_deposit in", values, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositNotIn(List<Long> values) {
            addCriterion("occupy_deposit not in", values, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositBetween(Long value1, Long value2) {
            addCriterion("occupy_deposit between", value1, value2, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andOccupyDepositNotBetween(Long value1, Long value2) {
            addCriterion("occupy_deposit not between", value1, value2, "occupyDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositIsNull() {
            addCriterion("loss_deposit is null");
            return (Criteria) this;
        }

        public Criteria andLossDepositIsNotNull() {
            addCriterion("loss_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andLossDepositEqualTo(Long value) {
            addCriterion("loss_deposit =", value, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositNotEqualTo(Long value) {
            addCriterion("loss_deposit <>", value, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositGreaterThan(Long value) {
            addCriterion("loss_deposit >", value, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositGreaterThanOrEqualTo(Long value) {
            addCriterion("loss_deposit >=", value, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositLessThan(Long value) {
            addCriterion("loss_deposit <", value, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositLessThanOrEqualTo(Long value) {
            addCriterion("loss_deposit <=", value, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositIn(List<Long> values) {
            addCriterion("loss_deposit in", values, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositNotIn(List<Long> values) {
            addCriterion("loss_deposit not in", values, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositBetween(Long value1, Long value2) {
            addCriterion("loss_deposit between", value1, value2, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andLossDepositNotBetween(Long value1, Long value2) {
            addCriterion("loss_deposit not between", value1, value2, "lossDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositIsNull() {
            addCriterion("make_up_deposit is null");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositIsNotNull() {
            addCriterion("make_up_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositEqualTo(Long value) {
            addCriterion("make_up_deposit =", value, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositNotEqualTo(Long value) {
            addCriterion("make_up_deposit <>", value, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositGreaterThan(Long value) {
            addCriterion("make_up_deposit >", value, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositGreaterThanOrEqualTo(Long value) {
            addCriterion("make_up_deposit >=", value, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositLessThan(Long value) {
            addCriterion("make_up_deposit <", value, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositLessThanOrEqualTo(Long value) {
            addCriterion("make_up_deposit <=", value, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositIn(List<Long> values) {
            addCriterion("make_up_deposit in", values, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositNotIn(List<Long> values) {
            addCriterion("make_up_deposit not in", values, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositBetween(Long value1, Long value2) {
            addCriterion("make_up_deposit between", value1, value2, "makeUpDeposit");
            return (Criteria) this;
        }

        public Criteria andMakeUpDepositNotBetween(Long value1, Long value2) {
            addCriterion("make_up_deposit not between", value1, value2, "makeUpDeposit");
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