  Feature: MangaServices
     When call removeLikeAs and category doesnt exist return warning

  Scenario Outline:
      The mangaService searched list using regex
      Given a manga list
      When user write category <tag> and is doesnt exist
      Then result should be return exception

           Examples:
              | tag       |
              | "types"   |