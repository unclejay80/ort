/*
 * Copyright (C) 2021 Bosch.IO GmbH
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

package org.ossreviewtoolkit.model.config

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class PathExcludeTest : WordSpec({
    "isPathExcluded" should {
        "ignore leading './' in the matching path" {
            val pathExclude = pathExclude("./path")

            pathExclude.matches("path") shouldBe true
        }

        "match zero up to multiple segments for a leading double asterisk" {
            val pathExclude = pathExclude("**/path/file.ext")

            pathExclude.matches("path/file.ext") shouldBe true
            pathExclude.matches("1/path/file.ext") shouldBe true
            pathExclude.matches("1/2/path/file.ext") shouldBe true
        }
    }
})

private fun pathExclude(pattern: String) = PathExclude(pattern, PathExcludeReason.BUILD_TOOL_OF)
