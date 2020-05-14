package com.wthink.car_cust.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCarExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCarNameIsNull() {
            addCriterion("car_name is null");
            return (Criteria) this;
        }

        public Criteria andCarNameIsNotNull() {
            addCriterion("car_name is not null");
            return (Criteria) this;
        }

        public Criteria andCarNameEqualTo(String value) {
            addCriterion("car_name =", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotEqualTo(String value) {
            addCriterion("car_name <>", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameGreaterThan(String value) {
            addCriterion("car_name >", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameGreaterThanOrEqualTo(String value) {
            addCriterion("car_name >=", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLessThan(String value) {
            addCriterion("car_name <", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLessThanOrEqualTo(String value) {
            addCriterion("car_name <=", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLike(String value) {
            addCriterion("car_name like", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotLike(String value) {
            addCriterion("car_name not like", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameIn(List<String> values) {
            addCriterion("car_name in", values, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotIn(List<String> values) {
            addCriterion("car_name not in", values, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameBetween(String value1, String value2) {
            addCriterion("car_name between", value1, value2, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotBetween(String value1, String value2) {
            addCriterion("car_name not between", value1, value2, "carName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNull() {
            addCriterion("car_color is null");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNotNull() {
            addCriterion("car_color is not null");
            return (Criteria) this;
        }

        public Criteria andCarColorEqualTo(String value) {
            addCriterion("car_color =", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotEqualTo(String value) {
            addCriterion("car_color <>", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThan(String value) {
            addCriterion("car_color >", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThanOrEqualTo(String value) {
            addCriterion("car_color >=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThan(String value) {
            addCriterion("car_color <", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThanOrEqualTo(String value) {
            addCriterion("car_color <=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLike(String value) {
            addCriterion("car_color like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotLike(String value) {
            addCriterion("car_color not like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorIn(List<String> values) {
            addCriterion("car_color in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotIn(List<String> values) {
            addCriterion("car_color not in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorBetween(String value1, String value2) {
            addCriterion("car_color between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotBetween(String value1, String value2) {
            addCriterion("car_color not between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1IsNull() {
            addCriterion("car_type_id1 is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1IsNotNull() {
            addCriterion("car_type_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1EqualTo(Integer value) {
            addCriterion("car_type_id1 =", value, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1NotEqualTo(Integer value) {
            addCriterion("car_type_id1 <>", value, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1GreaterThan(Integer value) {
            addCriterion("car_type_id1 >", value, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1GreaterThanOrEqualTo(Integer value) {
            addCriterion("car_type_id1 >=", value, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1LessThan(Integer value) {
            addCriterion("car_type_id1 <", value, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1LessThanOrEqualTo(Integer value) {
            addCriterion("car_type_id1 <=", value, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1In(List<Integer> values) {
            addCriterion("car_type_id1 in", values, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1NotIn(List<Integer> values) {
            addCriterion("car_type_id1 not in", values, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1Between(Integer value1, Integer value2) {
            addCriterion("car_type_id1 between", value1, value2, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId1NotBetween(Integer value1, Integer value2) {
            addCriterion("car_type_id1 not between", value1, value2, "carTypeId1");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2IsNull() {
            addCriterion("car_type_id2 is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2IsNotNull() {
            addCriterion("car_type_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2EqualTo(Integer value) {
            addCriterion("car_type_id2 =", value, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2NotEqualTo(Integer value) {
            addCriterion("car_type_id2 <>", value, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2GreaterThan(Integer value) {
            addCriterion("car_type_id2 >", value, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2GreaterThanOrEqualTo(Integer value) {
            addCriterion("car_type_id2 >=", value, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2LessThan(Integer value) {
            addCriterion("car_type_id2 <", value, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2LessThanOrEqualTo(Integer value) {
            addCriterion("car_type_id2 <=", value, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2In(List<Integer> values) {
            addCriterion("car_type_id2 in", values, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2NotIn(List<Integer> values) {
            addCriterion("car_type_id2 not in", values, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2Between(Integer value1, Integer value2) {
            addCriterion("car_type_id2 between", value1, value2, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarTypeId2NotBetween(Integer value1, Integer value2) {
            addCriterion("car_type_id2 not between", value1, value2, "carTypeId2");
            return (Criteria) this;
        }

        public Criteria andCarPriceIsNull() {
            addCriterion("car_price is null");
            return (Criteria) this;
        }

        public Criteria andCarPriceIsNotNull() {
            addCriterion("car_price is not null");
            return (Criteria) this;
        }

        public Criteria andCarPriceEqualTo(BigDecimal value) {
            addCriterion("car_price =", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotEqualTo(BigDecimal value) {
            addCriterion("car_price <>", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceGreaterThan(BigDecimal value) {
            addCriterion("car_price >", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("car_price >=", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceLessThan(BigDecimal value) {
            addCriterion("car_price <", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("car_price <=", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceIn(List<BigDecimal> values) {
            addCriterion("car_price in", values, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotIn(List<BigDecimal> values) {
            addCriterion("car_price not in", values, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("car_price between", value1, value2, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("car_price not between", value1, value2, "carPrice");
            return (Criteria) this;
        }

        public Criteria andRebateIsNull() {
            addCriterion("rebate is null");
            return (Criteria) this;
        }

        public Criteria andRebateIsNotNull() {
            addCriterion("rebate is not null");
            return (Criteria) this;
        }

        public Criteria andRebateEqualTo(String value) {
            addCriterion("rebate =", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotEqualTo(String value) {
            addCriterion("rebate <>", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateGreaterThan(String value) {
            addCriterion("rebate >", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateGreaterThanOrEqualTo(String value) {
            addCriterion("rebate >=", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLessThan(String value) {
            addCriterion("rebate <", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLessThanOrEqualTo(String value) {
            addCriterion("rebate <=", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLike(String value) {
            addCriterion("rebate like", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotLike(String value) {
            addCriterion("rebate not like", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateIn(List<String> values) {
            addCriterion("rebate in", values, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotIn(List<String> values) {
            addCriterion("rebate not in", values, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateBetween(String value1, String value2) {
            addCriterion("rebate between", value1, value2, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotBetween(String value1, String value2) {
            addCriterion("rebate not between", value1, value2, "rebate");
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