package org.jackzeng.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZoomAfeFeatureExecutorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZoomAfeFeatureExecutorExample() {
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

        public Criteria andFeatureExecutorClassIdIsNull() {
            addCriterion("feature_executor_class_id is null");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdIsNotNull() {
            addCriterion("feature_executor_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdEqualTo(Long value) {
            addCriterion("feature_executor_class_id =", value, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdNotEqualTo(Long value) {
            addCriterion("feature_executor_class_id <>", value, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdGreaterThan(Long value) {
            addCriterion("feature_executor_class_id >", value, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("feature_executor_class_id >=", value, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdLessThan(Long value) {
            addCriterion("feature_executor_class_id <", value, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdLessThanOrEqualTo(Long value) {
            addCriterion("feature_executor_class_id <=", value, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdIn(List<Long> values) {
            addCriterion("feature_executor_class_id in", values, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdNotIn(List<Long> values) {
            addCriterion("feature_executor_class_id not in", values, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdBetween(Long value1, Long value2) {
            addCriterion("feature_executor_class_id between", value1, value2, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorClassIdNotBetween(Long value1, Long value2) {
            addCriterion("feature_executor_class_id not between", value1, value2, "featureExecutorClassId");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathIsNull() {
            addCriterion("input_field_jsonpath is null");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathIsNotNull() {
            addCriterion("input_field_jsonpath is not null");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathEqualTo(String value) {
            addCriterion("input_field_jsonpath =", value, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathNotEqualTo(String value) {
            addCriterion("input_field_jsonpath <>", value, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathGreaterThan(String value) {
            addCriterion("input_field_jsonpath >", value, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathGreaterThanOrEqualTo(String value) {
            addCriterion("input_field_jsonpath >=", value, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathLessThan(String value) {
            addCriterion("input_field_jsonpath <", value, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathLessThanOrEqualTo(String value) {
            addCriterion("input_field_jsonpath <=", value, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathLike(String value) {
            addCriterion("input_field_jsonpath like", value, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathNotLike(String value) {
            addCriterion("input_field_jsonpath not like", value, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathIn(List<String> values) {
            addCriterion("input_field_jsonpath in", values, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathNotIn(List<String> values) {
            addCriterion("input_field_jsonpath not in", values, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathBetween(String value1, String value2) {
            addCriterion("input_field_jsonpath between", value1, value2, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andInputFieldJsonpathNotBetween(String value1, String value2) {
            addCriterion("input_field_jsonpath not between", value1, value2, "inputFieldJsonpath");
            return (Criteria) this;
        }

        public Criteria andOutputFieldIsNull() {
            addCriterion("output_field is null");
            return (Criteria) this;
        }

        public Criteria andOutputFieldIsNotNull() {
            addCriterion("output_field is not null");
            return (Criteria) this;
        }

        public Criteria andOutputFieldEqualTo(String value) {
            addCriterion("output_field =", value, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldNotEqualTo(String value) {
            addCriterion("output_field <>", value, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldGreaterThan(String value) {
            addCriterion("output_field >", value, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldGreaterThanOrEqualTo(String value) {
            addCriterion("output_field >=", value, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldLessThan(String value) {
            addCriterion("output_field <", value, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldLessThanOrEqualTo(String value) {
            addCriterion("output_field <=", value, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldLike(String value) {
            addCriterion("output_field like", value, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldNotLike(String value) {
            addCriterion("output_field not like", value, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldIn(List<String> values) {
            addCriterion("output_field in", values, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldNotIn(List<String> values) {
            addCriterion("output_field not in", values, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldBetween(String value1, String value2) {
            addCriterion("output_field between", value1, value2, "outputField");
            return (Criteria) this;
        }

        public Criteria andOutputFieldNotBetween(String value1, String value2) {
            addCriterion("output_field not between", value1, value2, "outputField");
            return (Criteria) this;
        }

        public Criteria andIsMustIsNull() {
            addCriterion("is_must is null");
            return (Criteria) this;
        }

        public Criteria andIsMustIsNotNull() {
            addCriterion("is_must is not null");
            return (Criteria) this;
        }

        public Criteria andIsMustEqualTo(Byte value) {
            addCriterion("is_must =", value, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustNotEqualTo(Byte value) {
            addCriterion("is_must <>", value, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustGreaterThan(Byte value) {
            addCriterion("is_must >", value, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_must >=", value, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustLessThan(Byte value) {
            addCriterion("is_must <", value, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustLessThanOrEqualTo(Byte value) {
            addCriterion("is_must <=", value, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustIn(List<Byte> values) {
            addCriterion("is_must in", values, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustNotIn(List<Byte> values) {
            addCriterion("is_must not in", values, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustBetween(Byte value1, Byte value2) {
            addCriterion("is_must between", value1, value2, "isMust");
            return (Criteria) this;
        }

        public Criteria andIsMustNotBetween(Byte value1, Byte value2) {
            addCriterion("is_must not between", value1, value2, "isMust");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNull() {
            addCriterion("default_value is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("default_value is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(String value) {
            addCriterion("default_value =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(String value) {
            addCriterion("default_value <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(String value) {
            addCriterion("default_value >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("default_value >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(String value) {
            addCriterion("default_value <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("default_value <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLike(String value) {
            addCriterion("default_value like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotLike(String value) {
            addCriterion("default_value not like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(List<String> values) {
            addCriterion("default_value in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(List<String> values) {
            addCriterion("default_value not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("default_value between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("default_value not between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andVariableGroupIsNull() {
            addCriterion("variable_group is null");
            return (Criteria) this;
        }

        public Criteria andVariableGroupIsNotNull() {
            addCriterion("variable_group is not null");
            return (Criteria) this;
        }

        public Criteria andVariableGroupEqualTo(String value) {
            addCriterion("variable_group =", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupNotEqualTo(String value) {
            addCriterion("variable_group <>", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupGreaterThan(String value) {
            addCriterion("variable_group >", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupGreaterThanOrEqualTo(String value) {
            addCriterion("variable_group >=", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupLessThan(String value) {
            addCriterion("variable_group <", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupLessThanOrEqualTo(String value) {
            addCriterion("variable_group <=", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupLike(String value) {
            addCriterion("variable_group like", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupNotLike(String value) {
            addCriterion("variable_group not like", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupIn(List<String> values) {
            addCriterion("variable_group in", values, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupNotIn(List<String> values) {
            addCriterion("variable_group not in", values, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupBetween(String value1, String value2) {
            addCriterion("variable_group between", value1, value2, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupNotBetween(String value1, String value2) {
            addCriterion("variable_group not between", value1, value2, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNull() {
            addCriterion("data_source is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("data_source is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(String value) {
            addCriterion("data_source =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(String value) {
            addCriterion("data_source <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(String value) {
            addCriterion("data_source >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(String value) {
            addCriterion("data_source >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(String value) {
            addCriterion("data_source <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(String value) {
            addCriterion("data_source <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLike(String value) {
            addCriterion("data_source like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotLike(String value) {
            addCriterion("data_source not like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<String> values) {
            addCriterion("data_source in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<String> values) {
            addCriterion("data_source not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(String value1, String value2) {
            addCriterion("data_source between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(String value1, String value2) {
            addCriterion("data_source not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceIsNull() {
            addCriterion("data_interface is null");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceIsNotNull() {
            addCriterion("data_interface is not null");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceEqualTo(String value) {
            addCriterion("data_interface =", value, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceNotEqualTo(String value) {
            addCriterion("data_interface <>", value, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceGreaterThan(String value) {
            addCriterion("data_interface >", value, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceGreaterThanOrEqualTo(String value) {
            addCriterion("data_interface >=", value, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceLessThan(String value) {
            addCriterion("data_interface <", value, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceLessThanOrEqualTo(String value) {
            addCriterion("data_interface <=", value, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceLike(String value) {
            addCriterion("data_interface like", value, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceNotLike(String value) {
            addCriterion("data_interface not like", value, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceIn(List<String> values) {
            addCriterion("data_interface in", values, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceNotIn(List<String> values) {
            addCriterion("data_interface not in", values, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceBetween(String value1, String value2) {
            addCriterion("data_interface between", value1, value2, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andDataInterfaceNotBetween(String value1, String value2) {
            addCriterion("data_interface not between", value1, value2, "dataInterface");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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