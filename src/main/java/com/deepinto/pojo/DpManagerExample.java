package com.deepinto.pojo;

import java.util.ArrayList;
import java.util.List;

public class DpManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DpManagerExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMaUnameIsNull() {
            addCriterion("ma_uname is null");
            return (Criteria) this;
        }

        public Criteria andMaUnameIsNotNull() {
            addCriterion("ma_uname is not null");
            return (Criteria) this;
        }

        public Criteria andMaUnameEqualTo(String value) {
            addCriterion("ma_uname =", value, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameNotEqualTo(String value) {
            addCriterion("ma_uname <>", value, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameGreaterThan(String value) {
            addCriterion("ma_uname >", value, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameGreaterThanOrEqualTo(String value) {
            addCriterion("ma_uname >=", value, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameLessThan(String value) {
            addCriterion("ma_uname <", value, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameLessThanOrEqualTo(String value) {
            addCriterion("ma_uname <=", value, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameLike(String value) {
            addCriterion("ma_uname like", value, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameNotLike(String value) {
            addCriterion("ma_uname not like", value, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameIn(List<String> values) {
            addCriterion("ma_uname in", values, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameNotIn(List<String> values) {
            addCriterion("ma_uname not in", values, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameBetween(String value1, String value2) {
            addCriterion("ma_uname between", value1, value2, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaUnameNotBetween(String value1, String value2) {
            addCriterion("ma_uname not between", value1, value2, "maUname");
            return (Criteria) this;
        }

        public Criteria andMaPwdIsNull() {
            addCriterion("ma_pwd is null");
            return (Criteria) this;
        }

        public Criteria andMaPwdIsNotNull() {
            addCriterion("ma_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andMaPwdEqualTo(String value) {
            addCriterion("ma_pwd =", value, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdNotEqualTo(String value) {
            addCriterion("ma_pwd <>", value, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdGreaterThan(String value) {
            addCriterion("ma_pwd >", value, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdGreaterThanOrEqualTo(String value) {
            addCriterion("ma_pwd >=", value, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdLessThan(String value) {
            addCriterion("ma_pwd <", value, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdLessThanOrEqualTo(String value) {
            addCriterion("ma_pwd <=", value, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdLike(String value) {
            addCriterion("ma_pwd like", value, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdNotLike(String value) {
            addCriterion("ma_pwd not like", value, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdIn(List<String> values) {
            addCriterion("ma_pwd in", values, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdNotIn(List<String> values) {
            addCriterion("ma_pwd not in", values, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdBetween(String value1, String value2) {
            addCriterion("ma_pwd between", value1, value2, "maPwd");
            return (Criteria) this;
        }

        public Criteria andMaPwdNotBetween(String value1, String value2) {
            addCriterion("ma_pwd not between", value1, value2, "maPwd");
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