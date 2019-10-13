package com.sdjtu.platform.repository;

import com.sdjtu.platform.domain.LocalStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:25
 */
public interface LocalStorageRepository extends JpaRepository<LocalStorage, Long>, JpaSpecificationExecutor {

}
