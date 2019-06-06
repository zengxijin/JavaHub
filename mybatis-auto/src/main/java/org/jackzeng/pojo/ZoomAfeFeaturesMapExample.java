package org.jackzeng.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZoomAfeFeaturesMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZoomAfeFeaturesMapExample() {
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

        public Criteria andSceneTypeIsNull() {
            addCriterion("scene_type is null");
            return (Criteria) this;
        }

        public Criteria andSceneTypeIsNotNull() {
            addCriterion("scene_type is not null");
            return (Criteria) this;
        }

        public Criteria andSceneTypeEqualTo(Integer value) {
            addCriterion("scene_type =", value, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeNotEqualTo(Integer value) {
            addCriterion("scene_type <>", value, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeGreaterThan(Integer value) {
            addCriterion("scene_type >", value, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scene_type >=", value, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeLessThan(Integer value) {
            addCriterion("scene_type <", value, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeLessThanOrEqualTo(Integer value) {
            addCriterion("scene_type <=", value, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeIn(List<Integer> values) {
            addCriterion("scene_type in", values, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeNotIn(List<Integer> values) {
            addCriterion("scene_type not in", values, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeBetween(Integer value1, Integer value2) {
            addCriterion("scene_type between", value1, value2, "sceneType");
            return (Criteria) this;
        }

        public Criteria andSceneTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("scene_type not between", value1, value2, "sceneType");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdIsNull() {
            addCriterion("feature_executor_id is null");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdIsNotNull() {
            addCriterion("feature_executor_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdEqualTo(Long value) {
            addCriterion("feature_executor_id =", value, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdNotEqualTo(Long value) {
            addCriterion("feature_executor_id <>", value, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdGreaterThan(Long value) {
            addCriterion("feature_executor_id >", value, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("feature_executor_id >=", value, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdLessThan(Long value) {
            addCriterion("feature_executor_id <", value, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdLessThanOrEqualTo(Long value) {
            addCriterion("feature_executor_id <=", value, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdIn(List<Long> values) {
            addCriterion("feature_executor_id in", values, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdNotIn(List<Long> values) {
            addCriterion("feature_executor_id not in", values, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdBetween(Long value1, Long value2) {
            addCriterion("feature_executor_id between", value1, value2, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andFeatureExecutorIdNotBetween(Long value1, Long value2) {
            addCriterion("feature_executor_id not between", value1, value2, "featureExecutorId");
            return (Criteria) this;
        }

        public Criteria andSceneNoIsNull() {
            addCriterion("scene_no is null");
            return (Criteria) this;
        }

        public Criteria andSceneNoIsNotNull() {
            addCriterion("scene_no is not null");
            return (Criteria) this;
        }

        public Criteria andSceneNoEqualTo(String value) {
            addCriterion("scene_no =", value, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoNotEqualTo(String value) {
            addCriterion("scene_no <>", value, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoGreaterThan(String value) {
            addCriterion("scene_no >", value, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoGreaterThanOrEqualTo(String value) {
            addCriterion("scene_no >=", value, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoLessThan(String value) {
            addCriterion("scene_no <", value, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoLessThanOrEqualTo(String value) {
            addCriterion("scene_no <=", value, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoLike(String value) {
            addCriterion("scene_no like", value, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoNotLike(String value) {
            addCriterion("scene_no not like", value, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoIn(List<String> values) {
            addCriterion("scene_no in", values, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoNotIn(List<String> values) {
            addCriterion("scene_no not in", values, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoBetween(String value1, String value2) {
            addCriterion("scene_no between", value1, value2, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andSceneNoNotBetween(String value1, String value2) {
            addCriterion("scene_no not between", value1, value2, "sceneNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoIsNull() {
            addCriterion("quota_no is null");
            return (Criteria) this;
        }

        public Criteria andQuotaNoIsNotNull() {
            addCriterion("quota_no is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaNoEqualTo(String value) {
            addCriterion("quota_no =", value, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoNotEqualTo(String value) {
            addCriterion("quota_no <>", value, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoGreaterThan(String value) {
            addCriterion("quota_no >", value, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoGreaterThanOrEqualTo(String value) {
            addCriterion("quota_no >=", value, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoLessThan(String value) {
            addCriterion("quota_no <", value, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoLessThanOrEqualTo(String value) {
            addCriterion("quota_no <=", value, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoLike(String value) {
            addCriterion("quota_no like", value, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoNotLike(String value) {
            addCriterion("quota_no not like", value, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoIn(List<String> values) {
            addCriterion("quota_no in", values, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoNotIn(List<String> values) {
            addCriterion("quota_no not in", values, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoBetween(String value1, String value2) {
            addCriterion("quota_no between", value1, value2, "quotaNo");
            return (Criteria) this;
        }

        public Criteria andQuotaNoNotBetween(String value1, String value2) {
            addCriterion("quota_no not between", value1, value2, "quotaNo");
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