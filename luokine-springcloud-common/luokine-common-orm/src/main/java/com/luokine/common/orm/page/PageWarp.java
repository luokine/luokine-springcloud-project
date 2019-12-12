package com.luokine.common.orm.page;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: tianziquan
 */
@Data
@AllArgsConstructor
public class PageWarp {

    private int pageNum;

    private int pageSize;
}
