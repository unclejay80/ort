/*
 * Copyright (C) 2021 HERE Europe B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * License-Filename: LICENSE
 */

package org.ossreviewtoolkit.evaluator

import org.ossreviewtoolkit.model.OrtResult
import org.ossreviewtoolkit.model.Severity

/**
 * A [Rule] to check an [OrtResult].
 */
open class OrtResultRule(
    ruleSet: RuleSet,
    name: String,
) : Rule(ruleSet, name) {
    /**
     * The [OrtResult] to check.
     */
    val ortResult = ruleSet.ortResult

    override val description = "Evaluating ORT result rule '$name'."

    override fun issueSource() = "$name - ORT result"

    fun issue(severity: Severity, message: String, howToFix: String = ""): Unit =
        issue(
            severity = severity,
            pkgId = null,
            license = null,
            licenseSource = null,
            message = message,
            howToFix = howToFix
        )

    fun hint(message: String, howToFix: String = ""): Unit =
        hint(
            pkgId = null,
            license = null,
            licenseSource = null,
            message = message,
            howToFix = howToFix
        )

    fun warning(message: String, howToFix: String = ""): Unit =
        warning(
            pkgId = null,
            license = null,
            licenseSource = null,
            message = message,
            howToFix = howToFix
        )

    fun error(message: String, howToFix: String = ""): Unit =
        error(
            pkgId = null,
            license = null,
            licenseSource = null,
            message = message,
            howToFix = howToFix
        )
}
