package com.sdjtu.platform.repository;

import com.sdjtu.platform.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:26
 */
public interface PictureRepository  extends JpaRepository<Picture,Long>, JpaSpecificationExecutor  {


}
