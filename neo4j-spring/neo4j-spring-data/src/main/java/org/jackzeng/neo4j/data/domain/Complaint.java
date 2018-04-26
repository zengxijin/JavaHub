package org.jackzeng.neo4j.data.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author xijin.zeng created on 2018/4/25
 * JavaBean的命名最好不要有为id的自定义的字段，因为neo4j自带默认了一个字段就是neo4j
 * 否则可能会导致反序列化的时候是失败，尤其是在使用spring-neo4j-data的时候
 */
@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint extends BaseNodeEntity {
    private int id;
    private int day;
    private int month;
    private int year;
}
