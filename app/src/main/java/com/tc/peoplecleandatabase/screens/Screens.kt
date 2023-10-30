package com.tc.peoplecleandatabase.screens

import com.tc.peoplecleandatabase.screens.ScreenName.PEOPLE_DETAILS
import com.tc.peoplecleandatabase.screens.ScreenName.PEOPLE_DETAILS_HEADER
import com.tc.peoplecleandatabase.screens.ScreenName.PEOPLE_LIST
import com.tc.peoplecleandatabase.screens.ScreenName.PEOPLE_LIST_HEADER

enum class Screens(
    val route: String,
    val header: String
) {
    PeopleList(route = PEOPLE_LIST, header = PEOPLE_LIST_HEADER),
    PeopleDetails(route = PEOPLE_DETAILS, header = PEOPLE_DETAILS_HEADER)

}

object ScreenName {
    const val PEOPLE_LIST = "people_list"
    const val PEOPLE_LIST_HEADER = "People"
    const val PEOPLE_DETAILS = "people_details"
    const val PEOPLE_DETAILS_HEADER = "Details"
}
