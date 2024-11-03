    package com.example.developerwellness.util

    class ExerciseSuggestions {

        private val exercises = listOf(
            Exercise(NECK_STRETCH, NECK_STRETCH_DESCRIPTION),
            Exercise(SHOULDER_ROLLS, SHOULDER_ROLLS_DESCRIPTION),
            Exercise(WRIST_STRETCH, WRIST_STRETCH_DESCRIPTION),
            Exercise(RULE_20_20_20, RULE_20_20_20_DESCRIPTION),
            Exercise(EYE_ROLLING, EYE_ROLLING_DESCRIPTION)
        )

        fun getRandomExercise(): Exercise = exercises.random()

        companion object{
            private const val NECK_STRETCH = "Neck Stretch"
            private const val NECK_STRETCH_DESCRIPTION = "Gently tilt your head toward each shoulder"
            private const val SHOULDER_ROLLS = "Shoulder Rolls"
            private const val SHOULDER_ROLLS_DESCRIPTION = "Roll your shoulders forward and backward"
            private const val WRIST_STRETCH = "Wrist Stretch"
            private const val WRIST_STRETCH_DESCRIPTION = "Extend and flex your wrists"
            private const val RULE_20_20_20 = "20-20-20 Rule"
            private const val RULE_20_20_20_DESCRIPTION = "Look at something 20 feet away for 20 seconds"
            private const val EYE_ROLLING = "Eye Rolling"
            private const val EYE_ROLLING_DESCRIPTION = "Roll your eyes clockwise and counterclockwise"
        }
    }