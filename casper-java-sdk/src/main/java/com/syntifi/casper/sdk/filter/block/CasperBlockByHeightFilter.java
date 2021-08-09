package com.syntifi.casper.sdk.filter.block;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Filter class passed to service
 * {@link com.syntifi.casper.sdk.service.CasperService#getBlock(CasperBlockByHeightFilter)}
 * to filter a block by its height
 *
 * @author Alexandre Carvalho
 * @author Andre Bertolace
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
public class CasperBlockByHeightFilter {
    private long height;
}