package com.ehapps.templateProject.adapter.delegate

import android.view.View
import com.ehapps.core.domain.model.ShowCharacter
import com.ehapps.core.ui.adapter.MultiTypeDelegate
import com.ehapps.templateProject.R
import com.ehapps.templateProject.adapter.viewholder.CharacterViewHolder
import com.ehapps.templateProject.databinding.CharacterListItemBinding

class CharacterDelegate :
    MultiTypeDelegate<ShowCharacter, CharacterListItemBinding, CharacterViewHolder>() {

    override fun createViewHolder(itemView: View): CharacterViewHolder =
        CharacterViewHolder(CharacterListItemBinding.bind(itemView))

    override fun getItemViewType(): Int = R.layout.character_list_item
    override fun getItemId(item: ShowCharacter): String = item.id.toString()
}