package com.sdjtu.platform.modules.monitor.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * pv 与 ip 统计
 *
 * @Author: ytuan
 * @Date: 2019-10-12  19:23
 */
@Entity
@Data
@Table(name = "visits")
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String date;

    @Column(name = "pv_counts")
    private Long pvCounts;

    @Column(name = "ip_counts")
    private Long ipCounts;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "week_day")
    private String weekDay;
}
