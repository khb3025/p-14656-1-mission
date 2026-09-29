package com.back.domain.post.post.document;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.OffsetDateTime;

@Document(indexName = "post")
@Data
public class Post implements Persistable<String> {
    @Id
    private String id;
    @Field(type= FieldType.Text)
    private String title;
    @Field(type= FieldType.Text)
    private String content;
    @Field(type= FieldType.Keyword)
    private String author;

    @Field(
            type= FieldType.Date,
            format = DateFormat.date_time
    )

    private OffsetDateTime createdAt;

    @Field(
            type= FieldType.Date,
            format = DateFormat.date_time
    )
    private OffsetDateTime lastModifiedAt;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = OffsetDateTime.now();
        this.lastModifiedAt = OffsetDateTime.now();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                '}';
    }

    @Override
    public boolean isNew() {
        return id == null || (createdAt == null && lastModifiedAt == null);
    }
}
