package org.jackzeng.neo4j.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author xijin.zeng created on 2018/5/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NodeEntity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ssn;
    private String phone;
}
