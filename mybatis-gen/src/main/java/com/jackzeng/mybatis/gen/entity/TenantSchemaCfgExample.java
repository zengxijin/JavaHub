package com.jackzeng.mybatis.gen.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TenantSchemaCfgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TenantSchemaCfgExample() {
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

        public Criteria andTenant_idIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenant_idIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenant_idEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idLessThan(String value) {
            addCriterion("tenant_id <", value, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idLike(String value) {
            addCriterion("tenant_id like", value, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_idNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenant_id");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaIsNull() {
            addCriterion("tenant_schema is null");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaIsNotNull() {
            addCriterion("tenant_schema is not null");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaEqualTo(String value) {
            addCriterion("tenant_schema =", value, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaNotEqualTo(String value) {
            addCriterion("tenant_schema <>", value, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaGreaterThan(String value) {
            addCriterion("tenant_schema >", value, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_schema >=", value, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaLessThan(String value) {
            addCriterion("tenant_schema <", value, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaLessThanOrEqualTo(String value) {
            addCriterion("tenant_schema <=", value, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaLike(String value) {
            addCriterion("tenant_schema like", value, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaNotLike(String value) {
            addCriterion("tenant_schema not like", value, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaIn(List<String> values) {
            addCriterion("tenant_schema in", values, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaNotIn(List<String> values) {
            addCriterion("tenant_schema not in", values, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaBetween(String value1, String value2) {
            addCriterion("tenant_schema between", value1, value2, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andTenant_schemaNotBetween(String value1, String value2) {
            addCriterion("tenant_schema not between", value1, value2, "tenant_schema");
            return (Criteria) this;
        }

        public Criteria andDb_typeIsNull() {
            addCriterion("db_type is null");
            return (Criteria) this;
        }

        public Criteria andDb_typeIsNotNull() {
            addCriterion("db_type is not null");
            return (Criteria) this;
        }

        public Criteria andDb_typeEqualTo(String value) {
            addCriterion("db_type =", value, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeNotEqualTo(String value) {
            addCriterion("db_type <>", value, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeGreaterThan(String value) {
            addCriterion("db_type >", value, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeGreaterThanOrEqualTo(String value) {
            addCriterion("db_type >=", value, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeLessThan(String value) {
            addCriterion("db_type <", value, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeLessThanOrEqualTo(String value) {
            addCriterion("db_type <=", value, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeLike(String value) {
            addCriterion("db_type like", value, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeNotLike(String value) {
            addCriterion("db_type not like", value, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeIn(List<String> values) {
            addCriterion("db_type in", values, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeNotIn(List<String> values) {
            addCriterion("db_type not in", values, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeBetween(String value1, String value2) {
            addCriterion("db_type between", value1, value2, "db_type");
            return (Criteria) this;
        }

        public Criteria andDb_typeNotBetween(String value1, String value2) {
            addCriterion("db_type not between", value1, value2, "db_type");
            return (Criteria) this;
        }

        public Criteria andCreated_dateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreated_dateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_dateEqualTo(Date value) {
            addCriterion("created_date =", value, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateGreaterThan(Date value) {
            addCriterion("created_date >", value, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateLessThan(Date value) {
            addCriterion("created_date <", value, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateIn(List<Date> values) {
            addCriterion("created_date in", values, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_dateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "created_date");
            return (Criteria) this;
        }

        public Criteria andCreated_byIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreated_byIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_byEqualTo(String value) {
            addCriterion("created_by =", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotEqualTo(String value) {
            addCriterion("created_by <>", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byGreaterThan(String value) {
            addCriterion("created_by >", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLessThan(String value) {
            addCriterion("created_by <", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLike(String value) {
            addCriterion("created_by like", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotLike(String value) {
            addCriterion("created_by not like", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byIn(List<String> values) {
            addCriterion("created_by in", values, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotIn(List<String> values) {
            addCriterion("created_by not in", values, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "created_by");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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