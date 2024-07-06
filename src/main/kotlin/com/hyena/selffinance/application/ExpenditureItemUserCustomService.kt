package com.hyena.selffinance.application

import com.hyena.selffinance.application.model.CreateExpenditureItemUserCustomRequestModel
import com.hyena.selffinance.application.model.CreateExpenditureItemUserCustomResponseModel
import com.hyena.selffinance.application.model.ListExpenditureItemUserCustomResponseModel
import com.hyena.selffinance.application.utils.ThreadLocalContextUtils
import com.hyena.selffinance.domain.ExpenditureItemCategory
import com.hyena.selffinance.domain.ExpenditureItemUserCustom
import com.hyena.selffinance.domain.common.Amount
import com.hyena.selffinance.domain.repository.ExpenditureItemCategoryRepository
import com.hyena.selffinance.domain.repository.ExpenditureItemRepository
import com.hyena.selffinance.domain.repository.ExpenditureItemUserCustomRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/30/24
 */
@Service
@Transactional(readOnly = true)
class ExpenditureItemUserCustomService(
    private val expenditureItemRepository: ExpenditureItemRepository,
    private val expenditureItemUserCustomRepository: ExpenditureItemUserCustomRepository,
    private val expenditureItemCategoryRepository: ExpenditureItemCategoryRepository,
) {
    @Transactional
    fun create(requestModel: CreateExpenditureItemUserCustomRequestModel): CreateExpenditureItemUserCustomResponseModel {
        val findExpenditureItem = expenditureItemRepository.findByIdOrNull(requestModel.expenditureItemId)
            ?: throw IllegalArgumentException()

        val userId = ThreadLocalContextUtils.getUserIdOrThrowException()

        val saveExpenditureItemUserCustom = expenditureItemUserCustomRepository.save(
            ExpenditureItemUserCustom(
                userId = userId,
                expenditureItem = findExpenditureItem,
                amount = Amount(requestModel.amount),
                description = requestModel.description
            )
        )

        return CreateExpenditureItemUserCustomResponseModel(
            saveExpenditureItemUserCustom.id ?: throw IllegalStateException("ExpenditureItemUserCustom이 저장되지 않았습니다.")
        )
    }

    fun list(): ListExpenditureItemUserCustomResponseModel {
        val userId = ThreadLocalContextUtils.getUserIdOrThrowException()
        val findExpenditureItemUserCustoms = expenditureItemUserCustomRepository.findAllByUserId(userId)
        val findCategoryMapping = findCategoryMapping(findExpenditureItemUserCustoms)

        val response = findExpenditureItemUserCustoms.map {
            ListExpenditureItemUserCustomResponseModel.ListExpenditureItemUserCustomModel(
                id = it.id!!,
                title = it.expenditureItem.title,
                amount = it.amount.toString(),
                description = it.description,
                categories = toExpenditureItemCategoryModels(it, findCategoryMapping),
            )
        }

        return ListExpenditureItemUserCustomResponseModel(response)
    }

    private fun findCategoryMapping(expenditureItemUserCustoms: List<ExpenditureItemUserCustom>): Map<Long, ExpenditureItemCategory> {
        val allCategoryIds = expenditureItemUserCustoms.flatMap { it.expenditureItem.categoryIds }
        return expenditureItemCategoryRepository.findAllById(
            allCategoryIds
        ).associateBy { it.id!! }
    }

    private fun toExpenditureItemCategoryModels(
        expenditureItemUserCustom: ExpenditureItemUserCustom,
        categoryMapping: Map<Long, ExpenditureItemCategory>,
    ) = expenditureItemUserCustom.getCategoryIds()
        .asSequence()
        .map { categoryId -> categoryMapping[categoryId] }
        .filterNotNull()
        .map { category ->
            ListExpenditureItemUserCustomResponseModel.ListExpenditureItemCategoryModel(
                id = category.id!!,
                title = category.title
            )
        }.toList()
}
