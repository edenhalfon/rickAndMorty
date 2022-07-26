package com.ehapps.templateProject.homePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ehapps.core.domain.DomainResource
import com.ehapps.core.domain.model.ShowCharacter
import com.ehapps.core.domain.usecase.CharactersUseCase
import com.ehapps.core.ui.adapter.MultiTypeCollection
import com.ehapps.templateProject.adapter.delegate.CharacterDelegate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomePageViewModel(private val charactersUseCase: CharactersUseCase) : ViewModel() {

    val charactersStateFlow =
        MutableStateFlow<DomainResource<Any>>(DomainResource.Loading(actionCode = Actions.CHARACTERS.ordinal))

    init {
        viewModelScope.launch {
            charactersUseCase.getAllCharacters().collect {
                charactersStateFlow.value = it.data?.let { characters ->
                    val dataCollection = MultiTypeCollection.Builder()
                        .add(characters, CharacterDelegate())
                        .build()

                    DomainResource.Success(dataCollection, Actions.CHARACTERS.ordinal)

                } ?: DomainResource.Error("", Actions.CHARACTERS.ordinal)
            }
        }
    }

    enum class Actions {
        CHARACTERS
    }
}