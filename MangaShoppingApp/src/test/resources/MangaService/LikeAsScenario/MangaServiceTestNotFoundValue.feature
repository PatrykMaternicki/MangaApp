  Feature: MangaServices
    Return exception when value doesnt exist

  Scenario Outline:
      The mangaService searched list using regex
      Given a manga list
      When user use <tag> category, but value <value> doesnt exist
      Then result should be return not found value

           Examples:
              | tag              | value |
              | "autor"          | "Hiro Satana" |