package com.github.hps.service;


import com.github.hps.mapper.VersionMapper;
import com.github.hps.vo.VersionVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class VersionService {
    VersionMapper versionMapper;
    public VersionVo getVersion() {
        return versionMapper.getVersion(1);
    }
}