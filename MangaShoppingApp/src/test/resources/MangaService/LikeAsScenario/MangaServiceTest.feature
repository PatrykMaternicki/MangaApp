Feature: MangaServices
  Get manga, when category exist and autor is correct and value is exist

  Scenario Outline:
    The mangaService searched list using regex
    Given a manga list
    When user write category <tag> and <value> autor is exist
    Then then result should be manga

     Examples:
        | tag              | value |
        | "autor"          | "Kizouki Mangaka" |
