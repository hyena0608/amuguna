package com.hyena.selffinance.interfaces.controller

import com.hyena.selffinance.application.ExpenditureItemService
import com.hyena.selffinance.application.model.CreateExpenditureItemRequestModel
import com.hyena.selffinance.application.model.CreateExpenditureItemResponseModel
import com.hyena.selffinance.application.model.ListExpenditureItemResponseModel
import com.hyena.selffinance.application.model.common.DefaultApiResponseModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
@RestController
@RequestMapping("/api/v1/expenditure/item")
class ExpenditureItemController(
    private val expenditureItemService: ExpenditureItemService
) {
    @PostMapping
    fun createExpenditureItem(
        @RequestBody requestModel: CreateExpenditureItemRequestModel,
    ): ResponseEntity<DefaultApiResponseModel<CreateExpenditureItemResponseModel>> {
        return ResponseEntity.ok(
            DefaultApiResponseModel(
                success = true,
                response = expenditureItemService.create(requestModel)
            )
        )
    }

    @GetMapping
    fun listExpenditureItem(): ResponseEntity<DefaultApiResponseModel<List<ListExpenditureItemResponseModel.ListExpenditureItemModel>>> {
        return ResponseEntity.ok(
            DefaultApiResponseModel(
                success = true,
                response = expenditureItemService.list().models
            )
        )
    }
}
