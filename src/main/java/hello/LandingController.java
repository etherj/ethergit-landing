package hello;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LandingController {

    @RequestMapping("/")
    public String landing(Device device) {

        if (device.isNormal()) {
            return "landing/normal";
        } else if (device.isMobile()) {
            return "landing/mobile";
        } else if (device.isTablet()) {
            return "landing/tablet";
        }

        return "landing/normal";
    }


}
