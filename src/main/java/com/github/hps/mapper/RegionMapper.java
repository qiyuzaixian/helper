package com.github.hps.mapper;


import com.github.hps.bean.Region;
import com.github.hps.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionMapper {
    /**
     * 获得所有省
     *
     * @return List<Province>
     */
    public List<Region> getProvinceList();

    /**
     * 根据省Id获得该省下的市
     *
     * @return List<City>
     */
    public List<Region> getCityList(@Param(value = "provinceId") Integer provinceId);

    /**
     * 根据市Id获得该市下的县
     *
     * @return List<City>
     */
    public List<Region> getAreaList(@Param(value = "cityId") Integer cityId);

}
