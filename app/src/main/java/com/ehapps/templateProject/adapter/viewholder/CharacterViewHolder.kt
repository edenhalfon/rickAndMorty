package com.ehapps.templateProject.adapter.viewholder

import coil.load
import com.ehapps.core.domain.model.ShowCharacter
import com.ehapps.core.ui.adapter.MultiTypeViewHolder
import com.ehapps.templateProject.databinding.CharacterListItemBinding

class CharacterViewHolder(binding: CharacterListItemBinding) :
    MultiTypeViewHolder<ShowCharacter, CharacterListItemBinding>(binding) {


    override fun bind(item: ShowCharacter) {
        binding.avatar.load(item.image)
        binding.name.text = item.name
        binding.species.text = item.species
    }

}