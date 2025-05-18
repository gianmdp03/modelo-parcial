package com.modelo.parcial.modelo_parcial.service;

import com.modelo.parcial.modelo_parcial.model.Area;
import com.modelo.parcial.modelo_parcial.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.modelo.parcial.modelo_parcial.validation.AreaValidator.*;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;

    public Area crearArea(Area area)
    {
        comprobarAreaExistente(area.getNombre(), areaRepository);
        return areaRepository.save(area);
    }

    public List<Area> listarArea()
    {
        return areaRepository.findAll();
    }

    public void eliminarAreaPorNombre(String nombre)
    {
        comprobarAreaExistentePorNombre(nombre, areaRepository);
        areaRepository.deleteByNombre(nombre);
    }

    public void eliminarAreaPorId(Long id){
        comprobarAreaExistentePorId(id, areaRepository);
        areaRepository.deleteById(id);
    }

}
