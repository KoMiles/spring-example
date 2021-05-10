package com.example.elasticsearchdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author komiles@163.com
 * @date 2021-04-28 17:43
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "content-data-0510")
public class ContentDataModel implements Serializable {
    @Field(name = "id")
    private String id;

    @Field(name = "biz_id",type = FieldType.Keyword)
    @JsonProperty("biz_id")
    private String bizId;

    @Field(name = "biz_type",type = FieldType.Integer)
    @JsonProperty("biz_type")
    private Integer bizType;

    @Field(type = FieldType.Integer)
    @JsonProperty("level")
    private Integer level;

    @Field(name = "create_time",type = FieldType.Long)
    @JsonProperty("create_time")
    private String createTime;

    @Field(type = FieldType.Long)
    private String uid;

    @Field(name = "kol_level",type = FieldType.Integer)
    @JsonProperty("kol_level")
    private Integer kolLevel;

    @Field(type = FieldType.Integer)
    private Integer distribute;

    @Field(name = "tag_op",type = FieldType.Keyword)
    @JsonProperty("tag_op")
    private String tagOp;

    @Field(name = "tag_algo",type = FieldType.Keyword)
    @JsonProperty("tag_algo")
    private String tagAlgo;

    @Field(name = "tag_qx",type = FieldType.Keyword)
    @JsonProperty("tag_qx")
    private String tagQx;

    @Field(name = "tag_user",type = FieldType.Keyword)
    @JsonProperty("tag_user")
    private String tagUser;

    @Field(name = "mdd_user",type = FieldType.Keyword)
    @JsonProperty("mdd_user")
    private String mddUser;

    @Field(name = "mdd_algo",type = FieldType.Keyword)
    @JsonProperty("mdd_algo")
    private String mddAlgo;

    @Field(name = "mdd_op",type = FieldType.Keyword)
    @JsonProperty("mdd_op")
    private String mddOp;

    @Field(name = "mdd_user_parent",type = FieldType.Keyword)
    @JsonProperty("mdd_user_parent")
    private String mddUserParent;

    @Field(name = "mdd_qx_parent",type = FieldType.Keyword)
    @JsonProperty("mdd_qx_parent")
    private String mddQxParent;

    @Field(name = "poi_user",type = FieldType.Keyword)
    @JsonProperty("poi_user")
    private String PoiUser;

    @Field(name = "poi_algo",type = FieldType.Keyword)
    @JsonProperty("poi_algo")
    private String poiAlgo;

    @Field(name = "poi_op",type = FieldType.Keyword)
    @JsonProperty("poi_op")
    private String poiOp;

    @Field(name = "poi_user_parent",type = FieldType.Keyword)
    @JsonProperty("poi_user_parent")
    private String poiUserParent;

    @Field(name = "poi_qx_parent",type = FieldType.Keyword)
    @JsonProperty("poi_qx_parent")
    private String poiQxParent;

    @Field(type = FieldType.Float)
    @JsonProperty("score")
    private String score;

    @Field(name = "new_score",type = FieldType.Float)
    @JsonProperty("new_score")
    private String newScore;

    @Field(name = "interaction_cnt",type = FieldType.Long)
    @JsonProperty("interaction_cnt")
    private String interactionCnt;

    @Field(name = "vote_cnt",type = FieldType.Long)
    @JsonProperty("vote_cnt")
    private String voteCnt;

    @Field(name = "fav_cnt",type = FieldType.Long)
    @JsonProperty("fav_cnt")
    private String favCnt;

    @Field(name = "share_cnt",type = FieldType.Long)
    @JsonProperty("share_cnt")
    private String shareCnt;

    @Field(name = "comment_cnt",type = FieldType.Long)
    @JsonProperty("comment_cnt")
    private String commentCnt;

    @Field(name = "view_cnt",type = FieldType.Long)
    @JsonProperty("view_cnt")
    private String viewCnt;

    @Field(name = "play_cnt",type = FieldType.Long)
    @JsonProperty("play_cnt")
    private String playCnt;

    @Field(name = "channel_type",type = FieldType.Long)
    @JsonProperty("channel_type")
    private String channelType;

    @Field(name = "show_1d_uv",type = FieldType.Long)
    @JsonProperty("show_1d_uv")
    private String show1dUv;

    @Field(name = "click_1d_uv",type = FieldType.Long)
    @JsonProperty("click_1d_uv")
    private String click1dUv;

    @Field(name = "show_1d_pv",type = FieldType.Long)
    @JsonProperty("show_1d_pv")
    private String show1dPv;

    @Field(name = "click_1d_pv",type = FieldType.Long)
    @JsonProperty("click_1d_pv")
    private String click1dPv;

    @Field(name = "ctr_1d",type = FieldType.Long)
    @JsonProperty("ctr_1d")
    private String ctr1d;

    @Field(name = "show_7d_uv",type = FieldType.Long)
    @JsonProperty("show_7d_uv")
    private String show7dUv;

    @Field(name = "click_7d_uv",type = FieldType.Long)
    @JsonProperty("click_7d_uv")
    private String click7dUv;

    @Field(name = "show_7d_pv",type = FieldType.Long)
    @JsonProperty("show_7d_pv")
    private String show7dPv;

    @Field(name = "click_7d_pv",type = FieldType.Long)
    @JsonProperty("click_7d_pv")
    private String click7dPv;

    @Field(name = "ctr_7d",type = FieldType.Long)
    @JsonProperty("ctr_7d")
    private String ctr7d;

    @Field(name = "show_15d_uv",type = FieldType.Long)
    @JsonProperty("show_15d_uv")
    private String show15dUv;

    @Field(name = "click_15d_uv",type = FieldType.Long)
    @JsonProperty("click_15d_uv")
    private String click15dUv;

    @Field(name = "show_15d_pv",type = FieldType.Long)
    @JsonProperty("show_15d_pv")
    private String show15dPv;

    @Field(name = "click_15d_pv",type = FieldType.Long)
    @JsonProperty("click_15d_pv")
    private String click15dPv;

    @Field(name = "ctr_15d",type = FieldType.Long)
    @JsonProperty("ctr_15d")
    private String ctr15d;

    @Field(name = "show_30d_uv",type = FieldType.Long)
    @JsonProperty("show_30d_uv")
    private String show30dUv;

    @Field(name = "click_30d_uv",type = FieldType.Long)
    @JsonProperty("click_30d_uv")
    private String click30dUv;

    @Field(name = "show_30d_pv",type = FieldType.Long)
    @JsonProperty("show_30d_pv")
    private String show30dPv;

    @Field(name = "click_30d_pv",type = FieldType.Long)
    @JsonProperty("click_30d_pv")
    private String click30dPv;

    @Field(name = "ctr_30d",type = FieldType.Long)
    @JsonProperty("ctr_30d")
    private String ctr30d;
}
