package models

import define.JobLevel
import define.JobLevel.JobLevel
import define.JobLevel.JobLevel

case class Subscriber(name: String, email: String, mobile: String, jobLevel: Int)

case class GroupJobLevel(jobLevel: JobLevel, count: Int)