package com.mytechnic.sample.persistent.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.03.04.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "userEntity")
@Entity(name = "user_login_history")
public class UserLoginHistoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private int historyId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "created")
	private LocalDateTime created;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private UserEntity userEntity;
}
