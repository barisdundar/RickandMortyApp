package com.example.rickandmorty

import android.icu.text.IDNA

data class CharactherResponse(val info: IDNA.Info,
                              val results: List<RmCharacter>)
