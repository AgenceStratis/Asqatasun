/*
 * Asqatasun - Automated webpage assessment
 * Copyright (C) 2008-2015  Asqatasun.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: asqatasun AT asqatasun DOT org
 */
package org.asqatasun.rules.rgaa32016;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.asqatasun.entity.audit.TestSolution;
import org.asqatasun.ruleimplementation.AbstractDetectionPageRuleImplementation;
import org.asqatasun.rules.elementselector.CaptchaElementSelector;
import org.asqatasun.rules.elementselector.SimpleElementSelector;
import static org.asqatasun.rules.keystore.CssLikeQueryStore.CANVAS_NOT_IN_LINK_WITH_NOT_EMPTY_CONTENT_CSS_LIKE_QUERY;
import static org.asqatasun.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.asqatasun.rules.keystore.RemarkMessageStore.CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_CAPTCHA_MSG;

/**
 * Implementation of the rule 1.4.12 of the referential RGAA 3.2016
 *
 * For more details about the implementation, refer to <a href="http://doc.asqatasun.org/en/90_Rules/rgaa3.2016/01.Images/Rule-1-4-12.html">the rule 1.4.12 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/rgaa-accessibilite/criteres.html#test-1-4-12">1.4.12 rule specification</a>
 */

public class Rgaa32016Rule010412 extends AbstractDetectionPageRuleImplementation {

    /**
     * Default constructor
     */
    public Rgaa32016Rule010412  () {
        super(
                new CaptchaElementSelector(
                    new SimpleElementSelector(CANVAS_NOT_IN_LINK_WITH_NOT_EMPTY_CONTENT_CSS_LIKE_QUERY)),
                // solution when at least one element is found
                new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_CAPTCHA_MSG),
                // solution when no element is found
                new ImmutablePair(TestSolution.NOT_APPLICABLE,""),
                // evidence element
                TEXT_ELEMENT2
            );
    }

}