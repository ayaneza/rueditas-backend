package pe.edu.cibertec.rueditas_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_backend.dto.BuscarRequestDTO;
import pe.edu.cibertec.rueditas_backend.service.VehiculoService;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    ResourceLoader resourceLoader;


    @Override
    public String[] validarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException {

        String[] datosVehiculo = null;

        Resource resource = resourceLoader.getResource("classpath:vehiculo.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            if(buscarRequestDTO.placa().equals(datos[0])){
                datosVehiculo = new String[5];
                datosVehiculo[0] = datos[1]; // Marca
                datosVehiculo[1] = datos[2]; // Modelo
                datosVehiculo[2] = datos[3]; // Asientos
                datosVehiculo[3] = datos[4]; // Precio
                datosVehiculo[4] = datos[5]; // Color

                }
            }
            System.out.println("Request DTO enviado desde el frontend5: " + buscarRequestDTO.placa());
        }catch (IOException e){
            datosVehiculo= null;
            throw new IOException(e);
        }
        System.out.println("Request DTO enviado desde el frontend6: " + buscarRequestDTO.placa());
        System.out.println(datosVehiculo);
        return datosVehiculo;
    }

}
