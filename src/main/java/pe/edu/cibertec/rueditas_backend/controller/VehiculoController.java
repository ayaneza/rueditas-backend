package pe.edu.cibertec.rueditas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_backend.dto.BuscarRequestDTO;
import pe.edu.cibertec.rueditas_backend.dto.BuscarResponseDTO;
import pe.edu.cibertec.rueditas_backend.service.VehiculoService;

@RestController()
@RequestMapping("/datosvehiculo")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @PostMapping("/search")
    public BuscarResponseDTO buscar(@RequestBody BuscarRequestDTO buscarRequestDTO){

        try {
            String[] datosVehiculo = vehiculoService.validarVehiculo(buscarRequestDTO);

            if(datosVehiculo == null){
                return new BuscarResponseDTO("01","No se encontró un vehículo para la placa ingresada","","","","","");

            }
            return new BuscarResponseDTO("00", "", datosVehiculo[0], datosVehiculo[1], datosVehiculo[2], datosVehiculo[3],datosVehiculo[4]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new BuscarResponseDTO("99","Error: Ocurrió un problema","","","","","");
        }

    }
}
