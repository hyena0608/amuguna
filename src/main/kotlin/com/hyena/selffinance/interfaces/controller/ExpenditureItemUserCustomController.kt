package com.hyena.selffinance.interfaces.controller

import com.hyena.selffinance.application.ExpenditureItemUserCustomService
import com.hyena.selffinance.application.model.CreateExpenditureItemUserCustomRequestModel
import com.hyena.selffinance.application.model.CreateExpenditureItemUserCustomResponseModel
import com.hyena.selffinance.application.model.ListExpenditureItemUserCustomResponseModel
import com.hyena.selffinance.application.model.common.DefaultApiResponseModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @Description
 * @Owner hyunseo
 * @Date 7/6/24
 */
@RestController
@RequestMapping("/api/v1/expenditure/item/user")
class ExpenditureItemUserCustomController(
    private val expenditureItemUserCustomService: ExpenditureItemUserCustomService,
) {
    @PostMapping
    fun createExpenditureItemUserCustom(
        @RequestBody requestModel: CreateExpenditureItemUserCustomRequestModel,
    ): ResponseEntity<DefaultApiResponseModel<CreateExpenditureItemUserCustomResponseModel>> {
        return ResponseEntity.ok(
            DefaultApiResponseModel(
                success = true,
                response = expenditureItemUserCustomService.create(requestModel)
            )
        )
    }

    @GetMapping("/list")
    fun listExpenditureItemUserCustom(): ResponseEntity<DefaultApiResponseModel<List<ListExpenditureItemUserCustomResponseModel.ListExpenditureItemUserCustomModel>>> {
        return ResponseEntity.ok(
            DefaultApiResponseModel(
                success = true,
                response = expenditureItemUserCustomService.list().models
            )
        )
    }
}
