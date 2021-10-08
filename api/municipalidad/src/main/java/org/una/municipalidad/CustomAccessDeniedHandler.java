package org.una.municipalidad;

import lombok.SneakyThrows;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

public class CustomAccessDeniedHandler {
   /* @Override
    @SneakyThrows
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException arg2)
            throws IOException, ServletException {

        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.getWriter().write(new JSONObject()
                .put("timestamp", LocalDateTime.now())
                .put("mensaje", "Se requiere un permiso adicional para realizar esta acción")
                .toString());

    }*/
}
