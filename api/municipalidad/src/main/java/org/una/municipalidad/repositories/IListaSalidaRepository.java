package org.una.municipalidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.municipalidad.entities.ListaSalida;

import java.util.List;

@Repository
public interface IListaSalidaRepository extends JpaRepository<ListaSalida, Long> {


    public List<ListaSalida> findByDia(String dia);

    public List<ListaSalida> findByCantidad(int cantidad);
}
