package cn.mysj.center.exception;

import cn.mysj.center.domain.common.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: KaelviHN
 * @created: 2024/10/5
 * @description:Global 全局异常处理器
 **/
//@ControllerAdvice
public class WebGlobalExceptionHandle {

    private final Logger logger = LoggerFactory.getLogger(WebGlobalExceptionHandle.class);

    /**
     * Exception异常处理
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result<Object> exportHandle(HttpServletResponse response, Exception e) {
        logger.error(e.getMessage(), e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return Result.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),"服务器异常");
    }


    /**
     * 自定义异常处理
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(value = BidiException.class)
    public Result<Object> customExportHandle(BidiException e) {
        logger.error(e.getMessage(), e);
        return Result.fail(e.getStatus().value(),e.getMessage());
    }
}
