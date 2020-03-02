package ca.sfu.sell.utils;

import ca.sfu.sell.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMessage("success");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO success() {
        return null;
    }

    public static ResultVO error(Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage("failed");
        return resultVO;
    }
}
