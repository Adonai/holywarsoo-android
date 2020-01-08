package com.kanedias.holywarsoo.dto

import java.io.Serializable

/**
 * Entity representing board forum.
 * Forum is where topics are shown, sorted by date and divided in pages.
 * Forums can also contain subforums. Usually only moderators of the website can create new forums.
 *
 * @author Kanedias
 *
 * Created on 17.12.19
 */
data class Forum(
    val id: Int, // set after page is loaded

    // info
    val name: String,
    val link: String,
    val subtext: String,
    val category: String? = null, // only set for forums on the main page
    val lastMessageName: String,
    val lastMessageLink: String,
    val lastMessageDate: String,

    /**
     * True if you can write topics to this forum
     */
    val writable: Boolean = true,

    // counters
    val topicCount: Int = -1,
    val commentsCount: Int = -1,
    val pageCount: Int = -1,
    val currentPage: Int = -1,

    // child entities
    val subforums: List<Forum> = emptyList(),
    val topics: List<ForumTopic> = emptyList()
) : Serializable