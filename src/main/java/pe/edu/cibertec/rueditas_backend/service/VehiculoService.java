package pe.edu.cibertec.rueditas_backend.service;

import pe.edu.cibertec.rueditas_backend.dto.BuscarRequestDTO;

import java.io.IOException;

public interface VehiculoService {

    String[] validarVehiculo(BuscarRequestDTO buscarRequestDTO)throws IOException;
}
