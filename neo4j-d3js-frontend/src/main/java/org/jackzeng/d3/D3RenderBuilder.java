package org.jackzeng.d3;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Path;
import org.neo4j.driver.v1.types.Relationship;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author xijin.zeng created on 2018/5/25
 */
public final class D3RenderBuilder {

    @Data
    @Builder
    class D3Node implements Serializable {
        private String id;
        private List<String> labels;
        private Map<String, Object> properties;
    }

    @Data
    @Builder
    class D3Relationship {
        private String id;
        private String type;
        private String startNode;
        private String endNode;
        private Map<String, Object> properties;
    }

    private static final String COLUMNS = "columns";
    private static final String DATA = "data";
    private static final String GRAPH = "graph";
    private static final String NODES = "nodes";
    private static final String RELATIONSHIPS = "relationships";

    public static D3RenderWrapper buildD3Wrapper(StatementResult statementResult, String pathColumnName) {
        List<Map<String, Object>> results = Lists.newArrayList();
        Map<String, Object> result = Maps.newHashMap();
        result.put(COLUMNS, statementResult.keys());

        List<Map<String, Object>> data = Lists.newArrayList();
        Map<String, Object> graph = Maps.newHashMap();

        List<D3Node> nodes = Lists.newArrayList();
        List<D3Relationship> relationships = Lists.newArrayList();

        statementResult.list().forEach(
                record -> {
                    Path path = record.get(pathColumnName).asPath();
                    nodes.addAll(getNodesFromPath(path));
                    relationships.addAll(getRelationshipsFromPath(path));
                }
        );

        graph.put(NODES, nodes);
        graph.put(RELATIONSHIPS, relationships);

        data.add(ImmutableMap.of(GRAPH, graph));

        result.put(DATA, data);
        results.add(result);

        return D3RenderWrapper.builder()
                .results(results)
                .errors(Lists.newArrayList())
                .build();
    }

    private static List<D3Node> getNodesFromPath(Path path) {
        final List<D3Node> nodeBuffer = Lists.newArrayList();
        path.iterator().forEachRemaining(
                segment -> {
                    Node startNode = segment.start();
                    nodeBuffer.add(buildD3Node(startNode));

                    Node endNode = segment.end();
                    nodeBuffer.add(buildD3Node(endNode));
                }
        );

        return nodeBuffer;
    }

    private static List<D3Relationship> getRelationshipsFromPath(Path path) {
        final List<D3Relationship> relationshipBuffer = Lists.newArrayList();
        path.iterator().forEachRemaining(segment -> {
            Relationship relationship = segment.relationship();
            relationshipBuffer.add(buildD3Relationship(relationship));
        });

        return relationshipBuffer;
    }

    private static D3Relationship buildD3Relationship(Relationship relationship) {
        return D3Relationship.builder()
                .startNode(String.valueOf(relationship.startNodeId()))
                .endNode(String.valueOf(relationship.endNodeId()))
                .id(String.valueOf(relationship.id()))
                .type(relationship.type())
                .properties(relationship.asMap())
                .build();
    }

    private static D3Node buildD3Node(Node node) {
        //process labels
        List<String> labels = Lists.newArrayList();
        node.labels().forEach(labels::add);

        //process properties
        Map<String, Object> properties = node.asMap();

        return D3Node.builder()
                .id(String.valueOf(node.id()))
                .labels(labels)
                .properties(properties)
                .build();
    }
}
