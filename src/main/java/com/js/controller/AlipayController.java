package com.js.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 54110 on 2020/8/19.
 */
@RestController
public class AlipayController {

    @RequestMapping("/pay")
    @ResponseBody
    public void pay (HttpServletRequest httpRequest,
                           HttpServletResponse httpResponse)   throws ServletException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2021000118650166", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDaKA7ccup3JulsDmRNl1OGOd4oW+r1ux/vJVt9JsqwuKiytsNtr0BMahl9l8OE6KcvhEYLmbpF0rxJyGWfTOs9eCI/E7JF3CVlMLZyikBcT26ry4zlhfOcNa99nFTl3KwKa/bKD8q3WP7pQMD80W2C+EZMBZj+gxpDxxexOZFVLkTUfd4DsPn2MFJzPQR5w664dPYyWI6ZIXERp87lXzZO0daUEoErVCKuAhYsIk1SjQp3TL1vWCG2g6y8+1ENtkeNgrwOlFQAVRcz/90mFfaQBrHMSM5222iAJbGSSCDfw1+LWdLErl3cCAGYRK4SXVXwhJeBXoCRJnPWh+Ejeml9AgMBAAECggEBAIilMrnOmSJNE0SFtzoKoVyf/pFVEdUdgqEuyyGXHLqYz8IxTDP149Z5VsIeP2+OsrnGpoE5pz15BEtK5KxlZ6u3Bexwj+fGPv4lBwKzqiCn+HBPLU/PGYos7mFFfMAF+xUEDy79uUIi0niUAM3a+Ddi/9U6ZFx3DgqKOELgBjJNgtvrB8/F8oWzP9lzYgvs9S0+ExKrINYgxkLFJOoqEfQQNF+kPG1LNh32Xu28dGOE33D79dRheIeuvUU0RVpOb/xp62x4r3VuP0cub5RsNPnIR1kstXxq7i6tmy56wqfLzJwiOBHfWwjC1D1wS23c8uZpspYt//yfpoMpQ0tJ1pkCgYEA8ZYBFpY0EWODmF+7NjuXCeX4k0pf7BkjveTW2jfGYvVc5Woix8AuOu7R3Ikn1j8hIF56d5YgwChapyqPbgqex18nn1VPAOUk23qKIVM+zRCDlfeFPt3dTRFj489kfAJLns9Efei8wjsatdSDMC+shYuE2swYZMVMsxMapCpos8MCgYEA5yww2Pi7xL3LPNWiovrQ7Qy80VvaVFa/H1pLhqMAaOUfuf+c9KqSzqHWWsNfoSvI/c327+w0OEa798pDm/ogFHzFjej6UJxoBM+ps8X+upq1ASfX7+EIHnDkJEVKYttOpAK/dNab7ZKljB8gcLBC+cH0GA7iw2leh3WPzAFU2b8CgYEA7dVWVu0ib2f/2peMT/TUWgtL731N97o8JKtQFV7JcQzLGpOlj+8T1DLe6fUhAdv+ecZpXKewsFxJ+r58m8Ha1L5J3KN4dpIf+e6mY+53Khyy3oXiaKS1RDT1mQXIkAkWd07nx+jDQ5g6UH3ZdSvJ9WMINPqunS5btwP8u1eA4k8CgYBB/zW629gPZPfe2EbkLKL06gwF4SlFprZNpyOkvmhhifgyy6ztlLzwzPc7Vke45Z0uCF0VRePqpRcIuO/wWcpKzww/ZWIBHYX8yaRzNHVypLRELjHRw/bjaetYB4gjDOU4oagzHQnLG3CzvjcutMOKNjsPm0BV9YENPxzcawzkVQKBgHpwL+lyMH+MdLIM3tXl28aH/vt86x4abyYXn0dDqvPgSGJpg/SPXH6A4R4UDEZyQXviNnxVkrjuugyp7Jmv4VJKxKc7SBu7rStMttveIGOitCG5iUmyl2YKMRPe2g3lg7v1pgz3iATw3u/QkI0gOu3EPK2KPSE8p+M/xwxtu5iC", "json", "UTF-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyZh9v+daffljusLKFoDzb0rijRJbGpL+1IsdQCd0DuhoKL7OCxj23OGXfGPERy0MMidrisX7l1BdnbLQ3a1PBAkJnsZv2OI4lgZeTFG+/qlUv3heG7aiV8bDLynnNSkWxU9T5qZPHuctB5Mlulk0lAds0+pqCzTuGlMxs9lqkbdEefT6R9iibkq5rvCUHJy/etJp63PQB/60MJtJCPI3kozuC9y/5tvQIrVjM4XK/5v41Nr1lN5eyuf8Zx7o3JpRmXWxTkDbo3Bt/gOGIRR0FPwcp2Oi4yg/jEoQWEDJlHEloFZf+pxOQbc3yOEWUoOHfnFwkICkSTMkm6t8tW1XEwIDAQAB", "RSA2");  //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); //创建API对应的request

        //alipayRequest.setReturnUrl( "http://331t2j2729.zicp.vip/returlCallBack" );
        //支付宝的回调地址,支付结果异步通知
        alipayRequest.setNotifyUrl("http://331t2j2729.zicp.vip/returlCallBack"); //在公共参数中设置回跳和通知地址
        //alipayRequest.putOtherTextParam("app_auth_token", "201611BB8xxxxxxxxxxxxxxxxxxxedcecde6");//如果 ISV 代商家接入电脑网站支付能力，则需要传入 app_auth_token，使用第三方应用授权；自研开发模式请忽略
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"1234567890097654222222\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":8888.88," +
                "    \"subject\":\"玛莎拉蒂\"," +
                "    \"body\":\"随便来\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }" +
                "  }"); //填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
//        return form;
        httpResponse.setContentType("text/html;charset=" + "utf-8");
        httpResponse.getWriter().write(form); //直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


    @RequestMapping("/returlCallBack")
    public String returlCallBack(HttpServletRequest request , HttpResponse httpResp) throws AlipayApiException {
        Map<String, String> paramsMap = convertRequestParamsToMap(request);
        boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2igO3HLqdybpbA5kTZdThjneKFvq9bsf7yVbfSbKsLiosrbDba9ATGoZfZfDhOinL4RGC5m6RdK8Schln0zrPXgiPxOyRdwlZTC2copAXE9uq8uM5YXznDWvfZxU5dysCmv2yg/Kt1j+6UDA/NFtgvhGTAWY/oMaQ8cXsTmRVS5E1H3eA7D59jBScz0EecOuuHT2MliOmSFxEafO5V82TtHWlBKBK1QirgIWLCJNUo0Kd0y9b1ghtoOsvPtRDbZHjYK8DpRUAFUXM//dJhX2kAaxzEjOdttogCWxkkgg38Nfi1nSxK5d3AgBmESuEl1V8ISXgV6AkSZz1ofhI3ppfQIDAQAB", "utf-8", "RSA2"); //调用SDK验证签名
        if(signVerified){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
            System.out.println(paramsMap);
            return "success";
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
            return "fail";
        }
    }

    // 将request中的参数转换成Map
    private static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap<String, String>();

        Set<Map.Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();

        for (Map.Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;

            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.toString().substring(1));
            } else {
                retMap.put(name, "");
            }
        }
        return retMap;
    }
}

