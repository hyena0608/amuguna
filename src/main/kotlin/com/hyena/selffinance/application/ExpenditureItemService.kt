package com.hyena.selffinance.application

import com.hyena.selffinance.application.model.CreateExpenditureItemRequestModel
import com.hyena.selffinance.application.model.CreateExpenditureItemResponseModel
import com.hyena.selffinance.application.model.ListExpenditureItemResponseModel
import com.hyena.selffinance.domain.ExpenditureItem
import com.hyena.selffinance.domain.repository.ExpenditureItemCategoryRepository
import com.hyena.selffinance.domain.repository.ExpenditureItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/29/24
 */
@Service
@Transactional(readOnly = true)
class ExpenditureItemService(
    private val expenditureItemRepository: ExpenditureItemRepository,
    private val expenditureItemCategoryRepository: ExpenditureItemCategoryRepository,
) {
    @Transactional
    fun create(requestModel: CreateExpenditureItemRequestModel): CreateExpenditureItemResponseModel {
        validateOrThrow(requestModel)

        val saveExpenditureItemId = expenditureItemRepository.save(
            ExpenditureItem(
                title = requestModel.title,
                categoryIds = requestModel.categoryIds,
            )
        ).id ?: throw IllegalStateException("ExpenditureItem 이 저장되지 않았습니다.")

        return CreateExpenditureItemResponseModel(saveExpenditureItemId)
    }

    private fun validateOrThrow(requestModel: CreateExpenditureItemRequestModel) {
        if (expenditureItemRepository.existsByTitle(requestModel.title)) {
            throw IllegalArgumentException()
        }
        if (expenditureItemCategoryRepository.existsAllBy(requestModel.categoryIds)) {
            throw IllegalArgumentException()
        }
    }

    fun list(): ListExpenditureItemResponseModel {
        val itemModels = expenditureItemRepository.findAll().map {
            ListExpenditureItemResponseModel.ListExpenditureItemModel(
                id = it.id!!,
                title = it.title
            )
        }

        return ListExpenditureItemResponseModel(itemModels)
    }
}
