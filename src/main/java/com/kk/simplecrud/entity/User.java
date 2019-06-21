package com.kk.simplecrud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zhangwengang
 * @Date: 2019/6/5
 * @Version: V1.0
 * @Description:
 */
@Table(name = "user")
@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键", example = "1")
    private Long id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;
    @Column(name = "age")
    private Integer age;
}
