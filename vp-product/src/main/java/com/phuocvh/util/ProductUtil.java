package com.phuocvh.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductUtil {

    public static <S, M> void findAndInsert(S sourceEntity, JpaRepository<M, UUID> mapRepository, Method setMapMethod, List<UUID> mapIds) throws InvocationTargetException, IllegalAccessException {
        if (mapIds.isEmpty()) return;
        try {
            List<M> list = mapRepository.findAllById(mapIds);
            if (!CollectionUtils.isEmpty(list)) setMapMethod.invoke(sourceEntity, list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static <S, M> void findAndInsert(S sourceEntity, JpaRepository<M, UUID> mapRepository, Method setMapMethod, UUID mapId) throws InvocationTargetException, IllegalAccessException {
        if (mapId == null) return;
        try {
            Optional<M> optional = mapRepository.findById(mapId);
            if (optional.isPresent()) setMapMethod.invoke(sourceEntity, optional.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
